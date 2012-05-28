package investit.app;

import investit.domain.ActionType;
import investit.domain.Instrument;
import investit.domain.InvestmentAction;
import investit.domain.MoneyValue;
import investit.domain.Portofolio;
import investit.services.detijd.FundSearcher;
import investit.util.DataSourceUtil;

import java.util.Date;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configurable
public class InvestitTestApp {
	
	public static void main(String... args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:**/applicationContext.xml");
		new InvestitTestApp().run();
		FundSearcher.main((String[])null);
		DataSourceUtil.closeBasicDataSource(ctx, "dataSource"); // forces the HSQL file to write to file
	}

	public void run() {
		Portofolio p = new Portofolio();
		p.setName("porto1");
		InvestmentAction a = createAction();
		p.getActions().add(a);
		a.setPortofolio(p);
		p.persist();
		for (Portofolio pf : Portofolio.findAllPortofoliosEagerFetchActionsAndDividends()) {
			System.out.println(pf.toString());
		}
	}

	private InvestmentAction createAction() {
		InvestmentAction a = new InvestmentAction();
		a.setActionDate(new Date());
		a.setActionType(ActionType.BUY);
		a.setAmount(1.0);
		MoneyValue m = new MoneyValue(100.0, "EUR");
		a.setCost(m);
		Instrument i = createInstrument();
		a.setInstrument(i); // instrument will be persisted later on thanks to
							// added CascadeType.Persist
		return a;
	}

	private Instrument createInstrument() {
		Instrument i = new Instrument();
		i.setIdAtSource(1234);
		i.setInstrumentInfo("info");
		i.setInstrumentType("FUND");
		i.setName("instr-name");
		i.setCompany("comp");
		return i;
	}
}
