package investit.domain;

import investit.base.InvestitBase;
import investit.services.detijd.InstrumentInfo;
import investit.util.DateUtils;
import investit.util.ToArray;
import investit.util.TypedQueryUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findPortofoliosByNameLike" })
public class Portofolio extends InvestitBase {
	
    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "portofolio")
    private Set<InvestmentAction> actions = new HashSet<InvestmentAction>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "portofolio")
    private Set<Dividend> dividends = new HashSet<Dividend>();

    public static List<Portofolio> findAllPortofoliosEagerFetchActionsAndDividends() {
        return entityManager().createQuery("SELECT o FROM Portofolio o LEFT JOIN FETCH o.actions LEFT JOIN FETCH o.dividends", Portofolio.class).getResultList();
    }

    //TODO let use decided to change the InstrumentInfo its price & last price time used as effectiveDate
	public void buy(InstrumentInfo iinfo, double amount, Date dateOfBuy, MoneyValue costs) {
		Instrument existingInstrument = TypedQueryUtils.getFirstOrNull(Instrument.findInstrumentsByISINCodeEquals(iinfo.getISINCode()));
		Instrument i = (existingInstrument!=null)? existingInstrument : Instrument.create(iinfo);
		//TODO solve: how to persist instrument? --> cascade? --> makes that flex detached instruments from an action are faulty persisted
		MoneyValue mv = new MoneyValue(iinfo.getLastPriceDouble(), iinfo.getCurrencySymbol());
		Date effectiveDate = iinfo.getLastPriceTime(); 
		//TODO round effectiveDate up to a DAY !!??
		if (i.hasNoValueForDate(dateOfBuy)) { // only create new instrument values
			warnIfNotSameDate(iinfo, dateOfBuy, effectiveDate);
			i.createInstrumentValue(mv, dateOfBuy, effectiveDate);
		}
		this.addNewInvestmentAction(ActionType.BUY,i,amount,dateOfBuy,costs);
	}

	//TODO move to instrument info?
	private void warnIfNotSameDate(InstrumentInfo iinfo, Date dateOfBuy,Date effectiveDate) {
		if (DateUtils.notOnSameDay(dateOfBuy,effectiveDate)) {
			if (logger.isWarnEnabled()) {
				logger.warn("InstrumentInfo for {} (ISIN={}) gives us for dateOfBuy={} no info, but info for effectiveDate={}.",ToArray.these(iinfo.getName(),iinfo.getISINCode(),dateOfBuy,effectiveDate));
			}
		}
	}

	private void addNewInvestmentAction(ActionType type, Instrument i, double amount, Date dateOfBuy, MoneyValue costs) {
		InvestmentAction ia = new InvestmentAction();
		ia.setActionDate(DateUtils.roundToDay(dateOfBuy));
		ia.setCost(costs); // OK, or problems if detached etc...
		ia.setActionType(type);
		ia.setAmount(amount);
		ia.setInstrument(i);
		this.addInvestmentAction(ia);
	}

	private void addInvestmentAction(InvestmentAction ia) {
		ia.setPortofolio(this);
		this.actions.add(ia);
	}


}
