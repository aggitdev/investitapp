package investit.servicecases;

import investit.services.detijd.InstrumentInfo;

import java.util.ArrayList;
import java.util.List;

public class InstrumentInfoAssembler {

	public List<InstrumentInfoDTO> createDTO(List<InstrumentInfo> lst) {
		List<InstrumentInfoDTO> result = new ArrayList<InstrumentInfoDTO>();
		for (InstrumentInfo instrumentInfo : lst) {
			result.add(createDTO(instrumentInfo));
		}
		return result;
	}

	private InstrumentInfoDTO createDTO(InstrumentInfo instr) {
		InstrumentInfoDTO dto = new InstrumentInfoDTO();
		dto.setInstrumentId(instr.getInstrumentId());
		dto.setName(instr.getName());
		dto.setCompany(instr.getCompany());
		dto.setISINCode(instr.getISINCode());
		dto.setInstrumentType(instr.getInstrumentType());
		dto.setInfo(instr.getInfo());
		dto.setCurrencySymbol(instr.getCurrencySymbol());
		dto.setLastPriceDouble(instr.getLastPriceDouble());
		dto.setLastPriceTime(instr.getLastPriceTime());
		return dto;
	}

}
