package com.example.lab5vaadin.views;

import com.example.lab5vaadin.data.entity.Doctor;
import com.example.lab5vaadin.data.service.DoctorService;

import com.example.lab5vaadin.data.service.PatientService;
import com.example.lab5vaadin.security.SecurityService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Route(value = "", layout = MainView.class)
@PermitAll
public class EntityEdit extends VerticalLayout {
    private final DoctorService doctorService;


    final Grid<Doctor> grid;
    private final DoctorEditor doctorEditor;
    private final SecurityService securityService;
    private final Button addNewBtn;
    @Autowired
    public EntityEdit(DoctorService doctorService, DoctorEditor doctorEditor, SecurityService securityService) {
        this.doctorService = doctorService;
        this.doctorEditor = doctorEditor;
        this.securityService = securityService;
        this.grid = new Grid<>();
        grid.addColumn(Doctor::getId).setHeader("ID");
        grid.addColumn(Doctor::getLastname).setHeader("Фамилия");
        grid.addColumn(Doctor::getFirstname).setHeader("Имя");
        grid.addColumn(Doctor::getMiddlename).setHeader("Отчество");
        grid.addColumn(Doctor::getType).setHeader("Тип");
        this.addNewBtn = new Button("Новый врач", VaadinIcon.PLUS.create());

        HorizontalLayout actions = new HorizontalLayout(addNewBtn);
        if(securityService.getAuthenticatedUser().getUsername() == "admin")
            add(actions, grid, doctorEditor);
        else
            add(grid);

        grid.setHeight("500px");
        grid.getColumnByKey("id");

        grid.asSingleSelect().addValueChangeListener(e -> {
            doctorEditor.d.open();
            doctorEditor.editCustomer(e.getValue());
        });
        addNewBtn.addClickListener((e -> {
            doctorEditor.d.open();

            doctorEditor.editCustomer(new Doctor());
        }));
        doctorEditor.setChangeHandler(()-> {
            doctorEditor.setVisible(false);
            listDoctors();
        });
        listDoctors();

    }
    public void listDoctors() {
        grid.setItems(doctorService.getAllDoctors());
    }

}
