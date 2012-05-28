package investit.flexutils;

import java.util.Collections;
import java.util.List;

import flex.messaging.io.BeanProxy;
import flex.messaging.io.AbstractProxy;

@SuppressWarnings({ "rawtypes", "serial" })
public class EnumProxy extends BeanProxy {
	static final String ACTION_SCRIPT_VALUE_NAME = "enumValue"; // standard
																// convention
																// for enum here

	static List propertyNames = Collections
			.singletonList(ACTION_SCRIPT_VALUE_NAME);

	public Object createInstance(String className) {
		Class cl = AbstractProxy.getClassFromClassName(className);

		if (cl.isEnum()) {
			return new EnumStub(cl);
		} else
			throw new IllegalArgumentException(
					"**** remoting.datatype.EnumProxy registered for a class which is not an enum: "
							+ cl.getName());
	}

	public Object getValue(Object instance, String propertyName) {
		if (propertyName.equals(ACTION_SCRIPT_VALUE_NAME))
			return instance.toString();

		throw new IllegalArgumentException("No property named: " + propertyName
				+ " on enum type");
	}

	public void setValue(Object instance, String propertyName, Object value) {
		EnumStub es = (EnumStub) instance;
		if (propertyName.equals(ACTION_SCRIPT_VALUE_NAME))
			es.value = (String) value;
		else
			throw new IllegalArgumentException("no EnumStub property: "
					+ propertyName);
	}

	@SuppressWarnings("unchecked")
	public Object instanceComplete(Object instance) {
		EnumStub es = (EnumStub) instance;
		return Enum.valueOf(es.cl, es.value);
	}

	public List getPropertyNames(Object instance) {
		if (!(instance instanceof Enum))
			throw new IllegalArgumentException(
					"getPropertyNames called with non Enum object");
		return propertyNames;
	}

	class EnumStub {
		EnumStub(Class c) {
			cl = c;
		}

		Class cl;
		String value;
	}

}