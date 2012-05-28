package investit.domain
{
	[RemoteClass(alias="investit.servicecases.ServiceResult")]
	public class ServiceResult  {
		
		public static const FAULT:String = "FAULT";
		public static const OK:String = "OK";
		
		public var status:String;
		public var message:String;
		
		
		public function isOK():Boolean {
			return OK == this.status;
		}
		
		public function isFault():Boolean {
			return FAULT == this.status;
		}		
		
		
	}
}