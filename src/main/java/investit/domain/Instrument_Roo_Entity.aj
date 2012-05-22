// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.domain;

import investit.domain.Instrument;
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

privileged aspect Instrument_Roo_Entity {
    
    declare @type: Instrument: @Entity;
    
    @PersistenceContext
    transient EntityManager Instrument.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Instrument.id;
    
    @Version
    @Column(name = "version")
    private Integer Instrument.version;
    
    public Long Instrument.getId() {
        return this.id;
    }
    
    public void Instrument.setId(Long id) {
        this.id = id;
    }
    
    public Integer Instrument.getVersion() {
        return this.version;
    }
    
    public void Instrument.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Instrument.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Instrument.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Instrument attached = Instrument.findInstrument(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Instrument.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Instrument.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Instrument Instrument.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Instrument merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Instrument.entityManager() {
        EntityManager em = new Instrument().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Instrument.countInstruments() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Instrument o", Long.class).getSingleResult();
    }
    
    public static List<Instrument> Instrument.findAllInstruments() {
        return entityManager().createQuery("SELECT o FROM Instrument o", Instrument.class).getResultList();
    }
    
    public static Instrument Instrument.findInstrument(Long id) {
        if (id == null) return null;
        return entityManager().find(Instrument.class, id);
    }
    
    public static List<Instrument> Instrument.findInstrumentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Instrument o", Instrument.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}