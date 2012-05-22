package  investit.domain{
	[RemoteClass(alias="investit.domain.InvestmentAction")]
	public class InvestmentAction {
		public var id:Number;
		public var version:Number;
		public var actionType:ActionType;
		public var amount:Number;
		public var actionDate:Date;
		public var cost:MoneyValue;
		public var instrument:Instrument;
		public var portofolio:Portofolio;
	}
}