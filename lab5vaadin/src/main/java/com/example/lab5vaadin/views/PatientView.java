package com.example.lab5vaadin.views;

import com.example.lab5vaadin.data.entity.Patient;
import com.example.lab5vaadin.data.service.PatientService;
import com.example.lab5vaadin.security.SecurityService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.server.auth.AnonymousAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
@PermitAll
@Route(value = "patients", layout = MainView.class)
public class PatientView extends VerticalLayout {
    private final PatientService patientService;
    private final SecurityService securityService;

    final Grid<Patient> grid;
    private final PatientEditor patientEditor;

    private final Button addNewBtn;
    @Autowired
    public PatientView(PatientService patientService, PatientEditor patientEditor, SecurityService securityService) {
        this.patientService = patientService;
        this.securityService = securityService;
        this.patientEditor = patientEditor;
        this.grid = new Grid<>();
        grid.addColumn(Patient::getId).setHeader("ID");
        grid.addColumn(Patient::getLastname).setHeader("Фамилия");
        grid.addColumn(Patient::getFirstname).setHeader("Имя");
        grid.addColumn(Patient::getMiddlename).setHeader("Отчество");
        this.addNewBtn = new Button("Новый пациент", VaadinIcon.PLUS.create());

        // build layout
        HorizontalLayout actions = new HorizontalLayout(addNewBtn);
        if(securityService.getAuthenticatedUser().getUsername() == "admin")
            add(actions, grid,patientEditor);
        else
            add( grid);

        grid.setHeight("500px");
        grid.getColumnByKey("id");



        // Hook logic to components


        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            patientEditor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> {patientEditor.editCustomer(new Patient());
        });

        // Listen changes made by the editor, refresh data from backend
        patientEditor.setChangeHandler(() -> {
            patientEditor.setVisible(false);
            listCustomers();
        });

        // Initialize listing
        listCustomers();
    }

    public void listCustomers() {
        grid.setItems(patientService.getAllPatients());
    }
}
