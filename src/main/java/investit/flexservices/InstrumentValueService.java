package investit.flexservices;

import investit.domain.InstrumentValue;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Service;

@RooFlexScaffold(entity = InstrumentValue.class)
@RemotingDestination
@Service
public class InstrumentValueService {
}
