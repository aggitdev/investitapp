package  investit.domain{
	[RemoteClass(alias="investit.domain.MoneyValue")]
	public class MoneyValue {
		
		// note: no arg constructor needed for remoting AMF
		
		//AG:added
		public static function create(moneyAmount:Number, moneyCurrency:String):MoneyValue {
			var mv:MoneyValue = new MoneyValue();
			mv.moneyAmount = moneyAmount;				
			mv.moneyCurrency = moneyCurrency;
			return mv;
		}	
		
		public var moneyAmount:Number;
		public var moneyCurrency:String;
	}
}