package com.induslink.app.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.springframework.stereotype.Component;

@PageTitle("IndusLink")
@Component
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
    }

    private void createHeader() {
        H1 logo = new H1("IndusLink");
        logo.addClassName("logo");

        // Updated navigation using buttons with navigation events
        Button machinesLink = new Button("Machines", e -> getUI().ifPresent(ui -> ui.navigate("machines")));
        Button devicesLink = new Button("Devices", e -> getUI().ifPresent(ui -> ui.navigate("devices")));
        Button infoLink = new Button("Info", e -> getUI().ifPresent(ui -> ui.navigate("info")));

        HorizontalLayout header = new HorizontalLayout(logo, machinesLink, devicesLink, infoLink);
        //header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.setWidthFull();
        header.expand(logo);

        addToNavbar(header);
    }
}
