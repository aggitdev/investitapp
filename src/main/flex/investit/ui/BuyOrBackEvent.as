package investit.ui
{
    import flash.events.Event;

    public class BuyOrBackEvent extends Event
    {
        public static const BUY:String = "BUY";
		public static const BACK:String = "BACK";
		private var _data:Object;
		
        public function BuyOrBackEvent(type:String, data:Object = null, bubbles:Boolean = true, cancelable:Boolean = false)
        {
            super(type, bubbles, cancelable);
			_data = data;
        }
		
		override public function clone():Event
		{
			return new BuyOrBackEvent(type, data, bubbles, cancelable);
		}

		public function get data():Object
		{
			return _data;
		}

		public function set data(value:Object):void
		{
			_data = value;
		}

    }
}