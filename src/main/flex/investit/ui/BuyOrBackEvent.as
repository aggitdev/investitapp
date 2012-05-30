package investit.ui
{
    import flash.events.Event;

	//TODO rename to InvestitEvent, note can have arbitrary data and different events buyEvent, backEvent, otherEvent,...
    public class BuyOrBackEvent extends Event
    {
        public static const BUY:String = "buyEvent"; // http://www.flexer.info/2008/05/30/how-to-add-an-event-to-a-custom-mxml-component-using-event-meta-tag/
		public static const BACK:String = "backEvent"; // this string must be the same as in the event metadatag name
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