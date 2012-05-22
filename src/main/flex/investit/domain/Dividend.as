package  investit.domain{
	[RemoteClass(alias="investit.domain.Dividend")]
	public class Dividend {
		public var id:Number;
		public var version:Number;
		public var dividendValue:MoneyValue;
		public var dividendDate:Date;
		public var instrument:Instrument;
		public var portofolio:Portofolio;
	}
}