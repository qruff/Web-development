package com.example.lab5vaadin.views;

import com.example.lab5vaadin.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

public class MainView extends AppLayout {
    private final SecurityService securityService;

    public MainView( @Autowired SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader(){
        H1 logo = new H1("Больница");
        logo.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM
        );
        Button logout = new Button("Log out ", e -> securityService.logout());
        HorizontalLayout header;
        if(securityService.getAuthenticatedUser() != null){
            header = new HorizontalLayout(new DrawerToggle(), logo, logout);
        } else {
            header = new HorizontalLayout(new DrawerToggle(), logo);
        }
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames(
                LumoUtility.Padding.Vertical.NONE,
                LumoUtility.Padding.Horizontal.MEDIUM
        );
        addToNavbar(header);
    }

    private void createDrawer(){
        addToDrawer(new VerticalLayout(
                new RouterLink("Врачи", EntityEdit.class),
                new RouterLink("Пациенты", PatientView.class),
                new RouterLink("Приемы", PriemView.class)
        ));
    }
}
