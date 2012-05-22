package  investit.domain{
	import mx.collections.ArrayCollection;
	[RemoteClass(alias="investit.domain.Portofolio")]
	public class Portofolio {
		public var id:Number;
		public var version:Number;
		public var name:String;
		public var actions:ArrayCollection;
		public var dividends:ArrayCollection;
	}
}