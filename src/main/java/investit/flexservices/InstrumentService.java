package investit.flexservices;

import investit.domain.Instrument;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Service;

@RooFlexScaffold(entity = Instrument.class)
@RemotingDestination
@Service
public class InstrumentService {
}
