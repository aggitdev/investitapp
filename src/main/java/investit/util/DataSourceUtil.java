package investit.util;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class DataSourceUtil {
	

	public static void closeBasicDataSource(ApplicationContext ctx, String dataSourceBeanName) {
		try {
			final BasicDataSource basicDataSource = (BasicDataSource)ctx.getBean(dataSourceBeanName);
			basicDataSource.close();
		} catch (BeansException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
