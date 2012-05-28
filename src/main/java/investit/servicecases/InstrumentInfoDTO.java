package investit.servicecases;

import investit.services.detijd.InstrumentInfo;

import java.util.Date;

public class InstrumentInfoDTO  implements InstrumentInfo {	
	
	private long instrumentId;
 	private String name;
	private String company;
	private String ISINCode;
	private String instrumentType;
	private String info;
	private String currencySymbol;
	private double lastPriceDouble;
	private Date lastPriceTime;
	
	
	public long getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(long instrumentId) {
		this.instrumentId = instrumentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getISINCode() {
		return ISINCode;
	}
	public void setISINCode(String iSINCode) {
		ISINCode = iSINCode;
	}
	public String getInstrumentType() {
		return instrumentType;
	}
	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public double getLastPriceDouble() {
		return lastPriceDouble;
	}
	public void setLastPriceDouble(double lastPriceDouble) {
		this.lastPriceDouble = lastPriceDouble;
	}
	public Date getLastPriceTime() {
		return lastPriceTime;
	}
	public void setLastPriceTime(Date lastPriceTime) {
		this.lastPriceTime = lastPriceTime;
	}
	@Override
	public String toXMLString() {
		return "<InstrumentInfoDTO>toXMLString not implemented</InstrumentInfoDTO>";
	}

}
