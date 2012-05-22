package  investit.domain{
	import mx.collections.ArrayCollection;
	[RemoteClass(alias="investit.domain.Instrument")]
	public class Instrument {
		public var id:Number;
		public var version:Number;
		public var idAtSource:Number;
		public var name:String;
		public var company:String;
		public var instrumentType:String;
		public var instrumentInfo:String;
		public var instrumentValues:ArrayCollection;
		public var iSINCode:String;
	}
}