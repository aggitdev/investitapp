// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.domain;

import investit.domain.InstrumentValue;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect InstrumentValue_Roo_Entity {
    
    declare @type: InstrumentValue: @Entity;
    
    @PersistenceContext
    transient EntityManager InstrumentValue.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long InstrumentValue.id;
    
    @Version
    @Column(name = "version")
    private Integer InstrumentValue.version;
    
    public Long InstrumentValue.getId() {
        return this.id;
    }
    
    public void InstrumentValue.setId(Long id) {
        this.id = id;
    }
    
    public Integer InstrumentValue.getVersion() {
        return this.version;
    }
    
    public void InstrumentValue.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void InstrumentValue.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void InstrumentValue.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            InstrumentValue attached = InstrumentValue.findInstrumentValue(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void InstrumentValue.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void InstrumentValue.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public InstrumentValue InstrumentValue.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        InstrumentValue merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager InstrumentValue.entityManager() {
        EntityManager em = new InstrumentValue().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long InstrumentValue.countInstrumentValues() {
        return entityManager().createQuery("SELECT COUNT(o) FROM InstrumentValue o", Long.class).getSingleResult();
    }
    
    public static List<InstrumentValue> InstrumentValue.findAllInstrumentValues() {
        return entityManager().createQuery("SELECT o FROM InstrumentValue o", InstrumentValue.class).getResultList();
    }
    
    public static InstrumentValue InstrumentValue.findInstrumentValue(Long id) {
        if (id == null) return null;
        return entityManager().find(InstrumentValue.class, id);
    }
    
    public static List<InstrumentValue> InstrumentValue.findInstrumentValueEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM InstrumentValue o", InstrumentValue.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
