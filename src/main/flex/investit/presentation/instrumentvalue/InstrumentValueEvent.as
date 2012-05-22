package investit.presentation.instrumentvalue
{
    import flash.events.Event;

    import investit.domain.InstrumentValue;

    public class InstrumentValueEvent extends Event
    {
        public static const CREATE:String = "instrumentValueCreate";
        public static const UPDATE:String = "instrumentValueUpdate";
        public static const DELETE:String = "instrumentValueDelete";

        public var instrumentValue:InstrumentValue;
        
        public function InstrumentValueEvent(type:String, instrumentValue:InstrumentValue, bubbles:Boolean = true, cancelable:Boolean = false)
        {
            this.instrumentValue = instrumentValue;
            super(type, bubbles, cancelable);
        }
    }
}