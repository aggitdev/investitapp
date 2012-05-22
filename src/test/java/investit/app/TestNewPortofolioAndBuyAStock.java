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

public class TestNewPortofolioAndBuyAStock extends InvestitSpringConfiguredAndDatasourceCloseTestBase {

	@Test
	@Transactional 
	// transactional --> we would like to load domain objects (eager load based on the use case), 
	// work with them, and then apply the right saves (based on the use case)
//	<instrument>
//	  <id>350001199</id>
//	  <name>KBC Group</name>
//	  <company>KBC Group</company>
//	  <isin>US48241F1049</isin>
//	  <type>Quote</type>
//	  <info>no info</info>
//	  <currency>USD</currency>
//	  <lastPrice>6.1</lastPrice>
//	  <lastPriceTime>Wed Dec 14 16:25:19 CET 2011</lastPriceTime>
//	  <todo>TODO other fields</todo>
//	</instrument>
	public void testBuyStock() {
		Portofolio p = new Portofolio();
		p.setName("testPorto");
		p.persist();
		
		Portofolio portofolio = Portofolio.findPortofoliosByNameLike("testPorto").getSingleResult();		
		
		InvestitServices srv = new InvestitServices();
		ListOfInstrumentInfos  il = srv.listInstrumentsWith("KBC");
		//il.println();
		InstrumentInfo i = il.selectInstrumentWithExternalServiceId(350001199); // kbc stock USD, see above
		MoneyValue costs = new MoneyValue(105.0,"EUR");
		Date dateOfBuy = DateUtils.today();
		double amount = 1.0;
		portofolio.buy(i, amount, dateOfBuy, costs); // creates other objects as well...		
		portofolio.persist();
	}


}
