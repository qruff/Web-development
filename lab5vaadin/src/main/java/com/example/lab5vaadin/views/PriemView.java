package com.example.lab5vaadin.views;

import com.example.lab5vaadin.data.entity.Priem;
import com.example.lab5vaadin.data.service.PriemService;
import com.example.lab5vaadin.security.SecurityService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;


@Route(value = "priems", layout = MainView.class)
@PermitAll
public class PriemView extends VerticalLayout {
    private final PriemService priemService;
    private final SecurityService securityService;

    final Grid<Priem> grid;
    private final PriemEditor priemEditor;

    @Autowired
    public PriemView(PriemService priemService, PriemEditor priemEditor,SecurityService securityService) {
        this.priemService = priemService;
        this.securityService = securityService;
        this.priemEditor = priemEditor;
        this.grid = new Grid<>();
        grid.addColumn(Priem::getId).setHeader("ID");
        grid.addColumn(Priem::getDoctor).setHeader("Врач");
        grid.addColumn(Priem::getPatient).setHeader("Пациент");
        grid.addColumn(Priem::getLocDate).setHeader("Дата");

        // build layout
        if(securityService.getAuthenticatedUser().getUsername() == "admin")
            add( grid,priemEditor);
        else
            add( grid);

        grid.setHeight("500px");
        grid.getColumnByKey("id");



        // Hook logic to components


        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            priemEditor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked


        // Listen changes made by the editor, refresh data from backend
        priemEditor.setChangeHandler(() -> {
            priemEditor.setVisible(false);
            listCustomers();
        });

        // Initialize listing
        listCustomers();
    }

    public void listCustomers() {

        grid.setItems(priemService.getAllPriems());

    }
}
