// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.flexservices;

import investit.domain.Instrument;
import java.lang.Long;
import java.util.List;

privileged aspect InstrumentService_Roo_Service {
    
    public Instrument InstrumentService.create(Instrument instrument) {
        instrument.persist();
        return instrument;
    }
    
    public Instrument InstrumentService.show(Long id) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        return Instrument.findInstrument(id);
    }
    
    public List<Instrument> InstrumentService.list() {
        return Instrument.findAllInstruments();
    }
    
    public List<Instrument> InstrumentService.listPaged(Integer page, Integer size) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            return Instrument.findInstrumentEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo);
        } else {
            return list();
        }
    }
    
    public Instrument InstrumentService.update(Instrument instrument) {
        if (instrument == null) throw new IllegalArgumentException("A instrument is required");
        instrument=instrument.merge();
        return instrument;
    }
    
    public void InstrumentService.remove(Long id) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Instrument.findInstrument(id).remove();
    }
    
}
