package investit.dto
{
	// contains instrument & instumentvalue info
	[RemoteClass(alias="investit.servicecases.InstrumentInfoDTO")]
	[Bindable]
	public class InstrumentInfoDTO
	{
		public var instrumentId:Number;
		public var name:String;
		public var company:String;
		public var instrumentType:String;
		public var info:String;
		public var currencySymbol:String;
		public var ISINCode:String;
		public var lastPriceDouble:Number;
		public var lastPriceTime:Date;
	}
}
