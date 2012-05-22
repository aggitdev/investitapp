package investit.domain;

import javax.persistence.Embeddable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

//TODO make value object --> spring roo : private setters
@RooJavaBean
@RooToString
@Embeddable
public class MoneyValue {
	
	// for JPA
	public MoneyValue() {
	}	
	
	public MoneyValue(double amount, String currency) {
		setMoneyAmount(amount);
		setMoneyCurrency(currency);
	}

    @NotNull
    private double moneyAmount;

    @NotNull
    private String moneyCurrency;
}
