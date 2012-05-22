// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.flexservices;

import investit.domain.InvestmentAction;
import java.lang.Long;
import java.util.List;

privileged aspect InvestmentActionService_Roo_Service {
    
    public InvestmentAction InvestmentActionService.create(InvestmentAction investmentAction) {
        investmentAction.persist();
        return investmentAction;
    }
    
    public InvestmentAction InvestmentActionService.show(Long id) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        return InvestmentAction.findInvestmentAction(id);
    }
    
    public List<InvestmentAction> InvestmentActionService.list() {
        return InvestmentAction.findAllInvestmentActions();
    }
    
    public List<InvestmentAction> InvestmentActionService.listPaged(Integer page, Integer size) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            return InvestmentAction.findInvestmentActionEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo);
        } else {
            return list();
        }
    }
    
    public InvestmentAction InvestmentActionService.update(InvestmentAction investmentAction) {
        if (investmentAction == null) throw new IllegalArgumentException("A investmentAction is required");
        investmentAction=investmentAction.merge();
        return investmentAction;
    }
    
    public void InvestmentActionService.remove(Long id) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        InvestmentAction.findInvestmentAction(id).remove();
    }
    
}