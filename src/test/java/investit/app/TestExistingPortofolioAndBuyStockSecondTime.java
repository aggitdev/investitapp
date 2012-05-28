package investit.app;

import investit.domain.MoneyValue;
import investit.domain.Portofolio;
import investit.servicecases.InvestitServices;
import investit.servicecases.ListOfInstrumentInfos;
import investit.services.detijd.InstrumentInfo;
import investit.util.DateUtils;

import java.util.Date;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

//TODO to use .\db-backup-2011-12-26-20h52 HSQL database as a start
public class TestExistingPortofolioAndBuyStockSecondTime extends InvestitSpringConfiguredAndDatasourceCloseTestBase {

	@Test
	@Transactional 
	public void testBuyStockSecondTime() {
		Portofolio portofolio = Portofolio.findPortofoliosByNameLike("testPorto").getSingleResult();		
		
		InvestitServices srv = new InvestitServices();
		ListOfInstrumentInfos  il = srv.listInstrumentsWithHelper("KBC");
		//il.println();
		InstrumentInfo i = il.selectInstrumentWithExternalServiceId(350001199); // kbc stock USD, see above
		MoneyValue costs = new MoneyValue(200.0,"EUR");
		Date dateOfBuy = DateUtils.today();
		double amount = 4.0;
		portofolio.buy(i, amount, dateOfBuy, costs); // creates other objects as well...		
		portofolio.persist();
	}


}
