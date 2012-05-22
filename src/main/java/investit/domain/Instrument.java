package investit.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import investit.domain.InstrumentValue;
import investit.services.detijd.InstrumentInfo;
import investit.util.DateUtils;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findInstrumentsByIdAtSource", "findInstrumentsByISINCodeEquals" })
public class Instrument {

    @NotNull
    private long idAtSource;

    @NotNull
    private String name;

    @NotNull
    private String company;

    @NotNull
    private String instrumentType;

    private String instrumentInfo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instrument")
    private Set<InstrumentValue> instrumentValues = new HashSet<InstrumentValue>();

    @NotNull
    private String iSINCode;

    public static Instrument create(InstrumentInfo instrAndConditions) {
        Instrument i = new Instrument();
        i.setISINCode(instrAndConditions.getISINCode());
        i.setName(instrAndConditions.getName());
        i.setCompany(instrAndConditions.getCompany());
        i.setIdAtSource(instrAndConditions.getInstrumentId());
        i.setInstrumentType(instrAndConditions.getInstrumentType());
        return i;
    }

    /**
	 * The preferred way to create instrument values.
	 * Note that the date will be rounded to a day.
	 * @param valueDate date that will be used to put the value on
	 * @param effectiveDate date the value is effective the real value (note that effectiveDate could differ slightly from valueDate when there was no value available for the valueDate)
	 */
    public void createInstrumentValue(MoneyValue mv, Date valueDate, Date effectiveDate) {
        InstrumentValue iv = new InstrumentValue();
        iv.setMoneyValue(mv);
        iv.setValueDate(DateUtils.roundToDay(valueDate));
        iv.setEffectiveDate(DateUtils.roundToDay(effectiveDate));
        addInstrumentValue(iv);
    }

    /**
	 * The preferred way to add instrument values.
	 */
    public void addInstrumentValue(InstrumentValue iv) {
        iv.setInstrument(this);
        instrumentValues.add(iv);
    }

	public boolean hasNoValueForDate(Date dateOfBuyThatWillBeRoundedToADay) {
		return !hasValueForDay(dateOfBuyThatWillBeRoundedToADay);
	}

	public boolean hasValueForDay(Date dateOfBuyThatWillBeRoundedToADay) {
		return getValueForDayOrNull(dateOfBuyThatWillBeRoundedToADay)!=null;
	}
	
	public InstrumentValue getValueForDayOrNull(Date dateOfBuyThatWillBeRoundedToADay) {
		Date day = DateUtils.roundToDay(dateOfBuyThatWillBeRoundedToADay);
	    for (InstrumentValue iv : this.getInstrumentValues()) {
	    	if (day.equals(iv.getValueDate())) {
	    		return iv;
	    	}
		}
		return null;
	}
}
