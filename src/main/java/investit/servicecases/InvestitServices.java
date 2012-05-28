package investit.servicecases;

import investit.base.InvestitBase;
import investit.domain.MoneyValue;
import investit.domain.Portofolio;
import investit.services.detijd.FundSearcher;
import investit.services.detijd.InstrumentInfo;
import investit.services.detijd.InstrumentInfoList;
import investit.services.detijd.StockSearcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RemotingDestination
@Service
public class InvestitServices extends InvestitBase {
	
	//TODO: issues: BlazeDS will not serialize a property unless it has both a getter and a setter
	public List<InstrumentInfoDTO> listInstrumentsWith(String nameLike) {
		List<InstrumentInfo> lst = listInstrumentsWithHelper(nameLike).createInstrumentInfoList();
		return new InstrumentInfoAssembler().createDTO(lst);
	}

	//TODO make a BuyDTO
	@Transactional // note: this makes the domain actions in buy persisted by JPA to the database...TODO test and check
	public ServiceResult buy(long portofolioId, InstrumentInfo instrInfo, double amount, Date dateOfBuy, MoneyValue costs) {
		try {
			Portofolio portofolio = Portofolio.findPortofolio(portofolioId);
			if (portofolio==null) {
				return ServiceResult.noPortofolioFound();
			}		
			portofolio.buy(instrInfo, amount, dateOfBuy, costs); // todo notify from portofolio??
			return ServiceResult.buyOK();
		} catch (Exception e) {
			return ServiceResult.exceptionDuringBuy(e);
		}
	}

	public ListOfInstrumentInfos listInstrumentsWithHelper(String nameLike) {
		logInfo("listInstrumentsWith(\"%s\"):",nameLike);
		
		List<InstrumentInfo> result = new ArrayList<InstrumentInfo>();
		
		InstrumentInfoList fs = new FundSearcher().getInfoFor(nameLike);
		if (fs!=null) {
			List<InstrumentInfo> funds = fs.getInstruments();
			result.addAll(funds);
		}
		
		InstrumentInfoList ss = new StockSearcher().getInfoFor(nameLike);
		if (ss!=null) {
			List<InstrumentInfo> stocks = ss.getInstruments();		
			result.addAll(stocks);
		}
		
		ListOfInstrumentInfos lst = new ListOfInstrumentInfos(result);
		logInfo("found a ListOfInstrumentInfos with length %d",lst.size());		
		return lst;
	}


}
