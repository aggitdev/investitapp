package investit.presentation.instrument
{
    import flash.events.Event;

    import investit.domain.Instrument;

    public class InstrumentEvent extends Event
    {
        public static const CREATE:String = "instrumentCreate";
        public static const UPDATE:String = "instrumentUpdate";
        public static const DELETE:String = "instrumentDelete";

        public var instrument:Instrument;
        
        public function InstrumentEvent(type:String, instrument:Instrument, bubbles:Boolean = true, cancelable:Boolean = false)
        {
            this.instrument = instrument;
            super(type, bubbles, cancelable);
        }
    }
}