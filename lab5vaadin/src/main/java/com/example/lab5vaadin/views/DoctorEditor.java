package com.example.lab5vaadin.views;

import com.example.lab5vaadin.data.entity.Doctor;
import com.example.lab5vaadin.data.entity.Patient;
import com.example.lab5vaadin.data.entity.Priem;
import com.example.lab5vaadin.data.service.DoctorService;
import com.example.lab5vaadin.data.service.PatientService;
import com.example.lab5vaadin.data.service.PriemService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

@SpringComponent
@Configuration
@UIScope
@RolesAllowed("ADMIN")
public class DoctorEditor extends VerticalLayout implements KeyNotifier {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PriemService priemService;
    private Doctor doctor;

    TextField lastname = new TextField("Фамилия");
    TextField firstname = new TextField("Имя");
    TextField middlename = new TextField("Отчество");
    ComboBox<String> type = new ComboBox<>("Тип");

    ComboBox<Patient> patients = new ComboBox<>("Пациент");
    DatePicker datePicker = new DatePicker();

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    Button priem = new Button("Priem", VaadinIcon.DOCTOR.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel,delete);

    Binder<Doctor> binder = new Binder<>();
    Dialog d = new Dialog();

    public Dialog getD() {
        return d;
    }

    private ChangeHandler changeHandler;
    @Autowired
    public DoctorEditor(DoctorService doctorService, PatientService patientService, PriemService priemService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.priemService = priemService;
        VerticalLayout vl = new VerticalLayout(lastname, firstname, middlename, type, actions);
        VerticalLayout vlW = new VerticalLayout(patients, datePicker, priem);
        HorizontalLayout hl = new HorizontalLayout(vl, vlW);
        d.add(hl);



        patients.setItems(patientService.getAllPatients());
        patients.setItemLabelGenerator(Patient::getLastname);
        type.setItems(new String[]{"Терапевт", "Хирург", "Кардиолог", "Офтальмолог"});
        binder.forField(lastname).bind(Doctor::getLastname, Doctor::setLastname);
        binder.forField(firstname).bind(Doctor::getFirstname, Doctor::setFirstname);
        binder.forField(middlename).bind(Doctor::getMiddlename, Doctor::setMiddlename);
        binder.forField(type).bind(Doctor::getType, Doctor::setType);

        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(doctor));
        priem.addClickListener(e -> priem(doctor));
        setVisible(false);
    }


    void delete(){
        doctorService.deleteDoctorById(doctor.getId());
        changeHandler.onChange();
    }
    void priem(Doctor doctor){
        Priem priem = new Priem();
        priem.setDoctor(doctor);
        priem.setPatient(patients.getOptionalValue().get());
        priem.setDate(datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        doctorService.editDoctor(doctor);
        priemService.savePriem(priem);
        changeHandler.onChange();
    }
    public interface ChangeHandler {
        void onChange();
    }
    void save(){
        doctorService.saveDoctor(doctor);
        changeHandler.onChange();
    }
    public final Collection<Component> editCustomer(Doctor c){
        if (c==null){
            setVisible(false);
            return null;
        }
        final boolean persisted = c.getId() !=null;
        if (persisted){
            doctor = doctorService.getDoctorById(c.getId());
        }else {
            doctor=c;
        }
        cancel.setVisible(persisted);
        binder.setBean(doctor);
        setVisible(true);
        lastname.focus();
        return null;
    }
    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }
    private void showEditorDialog(Doctor doctor) {
        DoctorEditor editor = new DoctorEditor(doctorService, patientService, priemService);
        editor.editCustomer(doctor);

        Dialog dialog = new Dialog();
        dialog.add(editor);
        dialog.open();
    }
}
