package com.example.lab5vaadin.views;
import com.example.lab5vaadin.data.entity.Patient;
import com.example.lab5vaadin.data.entity.Priem;
import com.example.lab5vaadin.data.service.DoctorService;
import com.example.lab5vaadin.data.service.PatientService;
import com.example.lab5vaadin.data.service.PriemService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
@SpringComponent
@UIScope
@RolesAllowed("ADMIN")
public class PriemEditor extends VerticalLayout implements KeyNotifier {
    private final DoctorService doctorService;
    private final PriemService priemService;
    private final PatientService patientService;

    /**
     * The currently edited customer
     */
    private Priem priem;

    /* Fields to edit properties in Customer entity */

    ComboBox<Patient> patients = new ComboBox<>("Пациент");
    DatePicker date = new DatePicker();
    /* Action buttons */
    // TODO why more code?
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Priem> binder = new Binder<>();
    private PriemEditor.ChangeHandler changeHandler;

    @Autowired
    public PriemEditor (DoctorService doctorService, PriemService priemService, PatientService patientService) {
        this.doctorService = doctorService;
        this.priemService = priemService;
        this.patientService = patientService;
        VerticalLayout vl = new VerticalLayout(patients, date, actions);
        VerticalLayout vlW = new VerticalLayout();
        HorizontalLayout hl = new HorizontalLayout(vl);
        add(hl);
        patients.setItems(patientService.getAllPatients());
        patients.setItemLabelGenerator(Patient::getLastname);

        // bind using naming convention
        binder.forField(patients).bind(Priem::getPatient,Priem::setPatient);
        binder.forField(date).bind(Priem::getLocDate, Priem::setLocDate);
        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");



        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(priem));
        setVisible(false);
    }

    void delete() {
        priem.setDate(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        priemService.deletePriemById(priem.getId());
        changeHandler.onChange();
    }


    void save() {
        priem.setDate(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        priem.setPatient(patients.getOptionalValue().get());
        priemService.savePriem(priem);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editCustomer(Priem c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            priem = priemService.getPriemById(c.getId());
        }
        else {
            priem = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(priem);

        setVisible(true);

        // Focus first name initially
        patients.focus();
    }

    public void setChangeHandler(PriemEditor.ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }
}
