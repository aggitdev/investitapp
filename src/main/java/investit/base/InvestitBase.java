package investit.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvestitBase {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void println(Object o) {
		System.out.println(o);
	}

}
