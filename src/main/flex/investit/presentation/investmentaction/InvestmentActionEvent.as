package investit.presentation.investmentaction
{
    import flash.events.Event;

    import investit.domain.InvestmentAction;

    public class InvestmentActionEvent extends Event
    {
        public static const CREATE:String = "investmentActionCreate";
        public static const UPDATE:String = "investmentActionUpdate";
        public static const DELETE:String = "investmentActionDelete";

        public var investmentAction:InvestmentAction;
        
        public function InvestmentActionEvent(type:String, investmentAction:InvestmentAction, bubbles:Boolean = true, cancelable:Boolean = false)
        {
            this.investmentAction = investmentAction;
            super(type, bubbles, cancelable);
        }
    }
}