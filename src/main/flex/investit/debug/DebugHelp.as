package investit.debug
{
	import investit.dto.InstrumentInfoDTO;
	
	import mx.controls.Alert;
	import mx.utils.ObjectUtil;

	public class DebugHelp
	{
		public function DebugHelp()
		{
		}
		
		public static function show(object:Object, title:String):void
		{
			Alert.show(ObjectUtil.toString(object),title);
		}
	}
}