package  investit.domain{
	[RemoteClass(alias="investit.domain.InstrumentValue")]
	public class InstrumentValue {
		public var id:Number;
		public var version:Number;
		public var moneyValue:MoneyValue;
		public var valueDate:Date;
		public var effectiveDate:Date;
		public var instrument:Instrument;
	}
}