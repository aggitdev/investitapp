package investit.presentation.portofolio
{
    import flash.events.Event;

    import investit.domain.Portofolio;

    public class PortofolioEvent extends Event
    {
        public static const CREATE:String = "portofolioCreate";
        public static const UPDATE:String = "portofolioUpdate";
        public static const DELETE:String = "portofolioDelete";

        public var portofolio:Portofolio;
        
        public function PortofolioEvent(type:String, portofolio:Portofolio, bubbles:Boolean = true, cancelable:Boolean = false)
        {
            this.portofolio = portofolio;
            super(type, bubbles, cancelable);
        }
    }
}