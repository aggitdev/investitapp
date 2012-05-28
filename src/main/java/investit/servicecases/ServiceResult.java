package investit.servicecases;

public class ServiceResult {

	private static final String FAULT = "FAULT";
	private static final String OK = "OK";

	public static ServiceResult noPortofolioFound() {
		return newServiceResultFault("No portofolio found");
	}
	
	public static ServiceResult exceptionDuringBuy(Exception e) {
		return newServiceResultFault("Exception during buy="+e.toString());
	}
	
	public static ServiceResult buyOK() {
		return newServiceResultOK("Buy OK");
	}
	
	private static ServiceResult newServiceResultFault(String message) {
		return new ServiceResult(FAULT, message);
	}
	
	private static ServiceResult newServiceResultOK(String message) {
		return new ServiceResult(OK, message);
	}
	
	private String status; // FAULT or OK
	private String message;

	public ServiceResult(String status, String message) {
		this.status = status;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
