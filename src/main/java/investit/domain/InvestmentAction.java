package investit.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import investit.domain.ActionType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import investit.domain.MoneyValue;
import javax.persistence.Embedded;
import investit.domain.Instrument;
import javax.persistence.ManyToOne;
import investit.domain.Portofolio;

@RooJavaBean
@RooToString
@RooEntity
public class InvestmentAction {

    @Enumerated
    private ActionType actionType;

    @NotNull
    private double amount;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date actionDate;

    @Embedded
    private MoneyValue cost;

    @NotNull
    @ManyToOne(cascade={CascadeType.PERSIST}) // AG:good idea? no because it makes that if we persist a new investmentaction, that then the instrument is persisted as well (even in the case when it is a detached object!)
    private Instrument instrument;

    @NotNull
    @ManyToOne
    private Portofolio portofolio;
}
