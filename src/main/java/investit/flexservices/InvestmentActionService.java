package investit.flexservices;

import investit.domain.InvestmentAction;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.roo.addon.RooFlexScaffold;
import org.springframework.stereotype.Service;

@RooFlexScaffold(entity = InvestmentAction.class)
@RemotingDestination
@Service
public class InvestmentActionService {
}
