package com.example.lab5vaadin.views;
import com.example.lab5vaadin.data.entity.Patient;
import com.example.lab5vaadin.data.service.PatientService;
import com.example.lab5vaadin.data.service.impl.PatientServiceImpl;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@SpringComponent
@UIScope
@RolesAllowed("ADMIN")
public class PatientEditor extends VerticalLayout implements KeyNotifier {
    private final PatientService patientService;

    private Patient patient;

    TextField lastname = new TextField("Фамилия");
    TextField firstname = new TextField("Имя");
    TextField middlename = new TextField("Отчество");

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    Button priem = new Button("Priem", VaadinIcon.DOCTOR.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Patient> binder = new Binder<>();
    private PatientEditor.ChangeHandler changeHandler;

    @Autowired
    public PatientEditor(PatientService patientService){
        this.patientService = patientService;
        VerticalLayout v1 = new VerticalLayout(lastname, firstname, middlename, actions);
        add(v1);
        binder.forField(lastname).bind(Patient::getLastname, Patient::setLastname);
        binder.forField(firstname).bind(Patient::getFirstname, Patient::setFirstname);
        binder.forField(middlename).bind(Patient::getMiddlename, Patient::setMiddlename);
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(patient));
        setVisible(false);
    }

    void delete(){
        patientService.deletePatientById(patient.getId());
        changeHandler.onChange();
    }
    void save(){
        patientService.savePatient(patient);
        changeHandler.onChange();
    }
    public final void editCustomer(Patient c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            patient = patientService.getPatientById(c.getId());
        }
        else {
            patient = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(patient);

        setVisible(true);

        // Focus first name initially
        lastname.focus();
    }
    public interface ChangeHandler {
        void onChange();
    }
    public void setChangeHandler(PatientEditor.ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }
}
