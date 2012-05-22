package investit.presentation.dividend
{
    import flash.events.Event;

    import investit.domain.Dividend;

    public class DividendEvent extends Event
    {
        public static const CREATE:String = "dividendCreate";
        public static const UPDATE:String = "dividendUpdate";
        public static const DELETE:String = "dividendDelete";

        public var dividend:Dividend;
        
        public function DividendEvent(type:String, dividend:Dividend, bubbles:Boolean = true, cancelable:Boolean = false)
        {
            this.dividend = dividend;
            super(type, bubbles, cancelable);
        }
    }
}