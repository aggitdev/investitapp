package investit.app;

import investit.domain.ActionType;
import investit.flexutils.EnumProxy;
import flex.messaging.io.PropertyProxyRegistry;

public class StartupBean {
	
	public StartupBean() {
		runStartupCode();
	}

	private void runStartupCode() {
		PropertyProxyRegistry.getRegistry().register(ActionType.class, new EnumProxy());
	}

}
