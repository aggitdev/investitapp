package investit.servicecases;

import investit.services.detijd.FundSearcher;
import investit.services.detijd.InstrumentInfo;
import investit.services.detijd.InstrumentInfoList;
import investit.services.detijd.StockSearcher;

import java.util.List;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

@RemotingDestination
@Service
public class InvestitServices {

	public ListOfInstrumentInfos listInstrumentsWith(String nameLike) {
		InstrumentInfoList fs = new FundSearcher().getInfoFor(nameLike);		
		List<InstrumentInfo> funds = fs.getInstruments();		
		InstrumentInfoList ss = new StockSearcher().getInfoFor(nameLike);		
		List<InstrumentInfo> stocks = ss.getInstruments();		
	    funds.addAll(stocks);
		return new ListOfInstrumentInfos(funds);
	}

}
