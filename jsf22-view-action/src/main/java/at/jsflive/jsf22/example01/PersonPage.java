package at.jsflive.jsf22.example01;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersonPage {
    @ManagedProperty("#{personRepository}")
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

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
