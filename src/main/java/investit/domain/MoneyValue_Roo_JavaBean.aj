// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.domain;

import java.lang.String;

privileged aspect MoneyValue_Roo_JavaBean {
    
    public double MoneyValue.getMoneyAmount() {
        return this.moneyAmount;
    }
    
    public void MoneyValue.setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
    
    public String MoneyValue.getMoneyCurrency() {
        return this.moneyCurrency;
    }
    
    public void MoneyValue.setMoneyCurrency(String moneyCurrency) {
        this.moneyCurrency = moneyCurrency;
    }
    
}