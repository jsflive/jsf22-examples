package at.jsflive.jsf22.example01;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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
