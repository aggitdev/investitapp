package investit.flexservices;

import investit.domain.Dividend;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Service;

@RooFlexScaffold(entity = Dividend.class)
@RemotingDestination
@Service
public class DividendService {
}
