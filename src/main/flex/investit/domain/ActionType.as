package  investit.domain {	

	[RemoteClass(alias="investit.domain.ActionType")]
	public class ActionType {
	
	  //AG:added
		public static function create(actionType:String):ActionType {
			return new ActionType(actionType.toUpperCase());
		}	

	  //AG: corrected manually from flex roo:
	  
	  public function ActionType(v:String="UNSET") {
	  	enumValue = v;
	  }
	  
	   // issue here is that it is removed by spring roo...
	   // you need to add public String enumValue in the .java enum class !! (hopefully ignored for the rest)
	   //public var enumValue:String;
	   
	   public var enumValue:String;
	   
	   
	    
	  
	    public function equals(other:ActionType):Boolean
    	{
        	return other.enumValue == enumValue;
    	}
    	
    	
	    public function toString():String
	    {
	        return enumValue;
	    }
    	 
	
	}
}
