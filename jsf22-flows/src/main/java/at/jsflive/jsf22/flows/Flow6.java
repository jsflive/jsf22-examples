package at.jsflive.jsf22.flows;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

@ApplicationScoped
public class Flow6 implements Serializable {

    @Produces @FlowDefinition
    public Flow buildFlow6(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "flow6";
        flowBuilder.id("", flowId);
        flowBuilder.flowCallNode("callFlow5")
                   .flowReference("", "flow5")
                   .outboundParameter("param1", "Parameter 1 from flow6");
        flowBuilder.viewNode("step1", "/flow6/step1.xhtml").markAsStartNode();
        flowBuilder.viewNode("final", "/flow6/final.xhtml");
        flowBuilder.viewNode("return-from-flow5", "/flow6/final.xhtml");
        flowBuilder.returnNode("return").fromOutcome("/flowTest");
        return flowBuilder.getFlow();
    }
}
