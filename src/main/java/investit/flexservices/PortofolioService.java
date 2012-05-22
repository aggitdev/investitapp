package investit.flexservices;

import investit.domain.Portofolio;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Service;

@RooFlexScaffold(entity = Portofolio.class)
@RemotingDestination
@Service
public class PortofolioService {
}
