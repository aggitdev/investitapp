package investit.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import investit.domain.MoneyValue;
import javax.persistence.Embedded;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import investit.domain.Instrument;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class InstrumentValue {

    @Embedded
    private MoneyValue moneyValue;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date valueDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date effectiveDate;

    @NotNull
    @ManyToOne
    private Instrument instrument;
}
