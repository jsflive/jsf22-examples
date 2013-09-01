package at.jsflive.jsf22.flows;

import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.util.Map;

@Named
@FlowScoped(value = "flow5")
public class Flow5Bean {

    public String storeValues() {
        Map<Object,Object> currentFlowScope = FacesContext.getCurrentInstance().getApplication().getFlowHandler().getCurrentFlowScope();
        currentFlowScope.put("value1", "V1");
        currentFlowScope.put("value2", "V2");
        currentFlowScope.put("value3", "V3");
        return "final";
    }
}
