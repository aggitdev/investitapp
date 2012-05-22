package investit.app;

import investit.util.DataSourceUtil;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


public abstract class InvestitSpringConfiguredAndDatasourceCloseTestBase extends InvestitSpringConfiguredTestBase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DataSourceUtil.closeBasicDataSource(getFirstAndOnly(staticApplicationContexts), "dataSource"); // forces the HSQL file to write to file
		logger.info("tearDownAfterClass ended");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(InvestitSpringConfiguredAndDatasourceCloseTestBase.class);

	private static ApplicationContext getFirstAndOnly(List<ApplicationContext> lst) {
		if (lst.size()!=1) {			
			logger.error("multiple applications contexts created");
		} 
		return lst.get(0);
	}

	@Before
	public void setUp() throws Exception {
	}
	
	private static List<ApplicationContext> staticApplicationContexts = new ArrayList<ApplicationContext>();

	@After
	public void tearDown() throws Exception {
		staticApplicationContexts.add(applicationContext);
	}

}
