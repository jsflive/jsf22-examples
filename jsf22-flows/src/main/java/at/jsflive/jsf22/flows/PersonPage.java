package at.jsflive.jsf22.flows;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class PersonPage {
    @Inject
    private PersonRepository personRepository;

    private int selectedId;
    private Person selectedPerson;

    public List<Person> getPersons() {
        return personRepository.getPersons();
    }

    public void loadPerson() {
        selectedPerson = personRepository.getPerson(selectedId);
    }

    public void addInfoMessage() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String msg = "View action " + (ctx.isPostback() ? "on postback" : "on initial request");
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
        ctx.getExternalContext().getFlash().setKeepMessages(true);
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int getSelectedId() {
        return selectedId;
    }

}
