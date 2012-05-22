// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.flexservices;

import investit.domain.Portofolio;
import java.lang.Long;
import java.util.List;

privileged aspect PortofolioService_Roo_Service {
    
    public Portofolio PortofolioService.create(Portofolio portofolio) {
        portofolio.persist();
        return portofolio;
    }
    
    public Portofolio PortofolioService.show(Long id) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        return Portofolio.findPortofolio(id);
    }
    
    public List<Portofolio> PortofolioService.list() {
        return Portofolio.findAllPortofolios();
    }
    
    public List<Portofolio> PortofolioService.listPaged(Integer page, Integer size) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            return Portofolio.findPortofolioEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo);
        } else {
            return list();
        }
    }
    
    public Portofolio PortofolioService.update(Portofolio portofolio) {
        if (portofolio == null) throw new IllegalArgumentException("A portofolio is required");
        portofolio=portofolio.merge();
        return portofolio;
    }
    
    public void PortofolioService.remove(Long id) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Portofolio.findPortofolio(id).remove();
    }
    
}