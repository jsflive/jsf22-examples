package at.jsflive.jsf22.example03.component;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@FacesComponent("at.jsflive.CollapsiblePanel")
public class CollapsiblePanel extends UINamingContainer {

    enum PropertyKeys {
        collapsed
    }

    public boolean isCollapsed() {
        return (Boolean) getStateHelper().eval(PropertyKeys.collapsed, Boolean.FALSE);
    }

    public void setCollapsed(boolean collapsed) {
        getStateHelper().put(PropertyKeys.collapsed, collapsed);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void toggle(ActionEvent e) {
        setCollapsed(!isCollapsed());
        setCollapsedValueExpression();
    }

    private void setCollapsedValueExpression() {
        ELContext ctx = FacesContext.getCurrentInstance().getELContext();
        ValueExpression ve = getValueExpression(PropertyKeys.collapsed.name());
        if (ve != null) {
            ve.setValue(ctx, isCollapsed());
        }
    }

}
