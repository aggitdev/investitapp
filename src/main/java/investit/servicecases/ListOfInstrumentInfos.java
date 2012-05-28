package investit.servicecases;

import investit.base.InvestitBase;
import investit.services.detijd.InstrumentInfo;

import java.util.ArrayList;
import java.util.List;

public class ListOfInstrumentInfos extends InvestitBase {
	
	private List<InstrumentInfo> instrumentsInfos = new ArrayList<InstrumentInfo>();

	public ListOfInstrumentInfos(List<InstrumentInfo> instrumentsInfos) {
		this.instrumentsInfos = instrumentsInfos;
	}

	public InstrumentInfo selectInstrumentWithExternalServiceId(long instrumentId) {
		for (InstrumentInfo iinfo : instrumentsInfos) {
			if (instrumentId == iinfo.getInstrumentId()) {
				return iinfo;
			}
		}
		return null;
	}
	
	public int size() {
		return instrumentsInfos.size();
	}

	public void println() {
		for (InstrumentInfo iinfo : instrumentsInfos) {
			println(iinfo.toXMLString());
		}
	}

	public List<InstrumentInfo> createInstrumentInfoList() {
		return new ArrayList<InstrumentInfo>(this.instrumentsInfos);
	}

}
