// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package investit.domain;

import java.lang.String;

privileged aspect InvestmentAction_Roo_ToString {
    
    public String InvestmentAction.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionDate: ").append(getActionDate()).append(", ");
        sb.append("ActionType: ").append(getActionType()).append(", ");
        sb.append("Amount: ").append(getAmount()).append(", ");
        sb.append("Cost: ").append(getCost()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Instrument: ").append(getInstrument()).append(", ");
        sb.append("Portofolio: ").append(getPortofolio()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}