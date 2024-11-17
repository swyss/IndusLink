package com.induslink.app.ui.views;

import com.induslink.app.ui.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route(value = "info", layout = MainLayout.class)
public class InfoView extends VerticalLayout {

    public InfoView() {
        setSizeFull();
        TextArea infoArea = new TextArea("Application Information");
        infoArea.setSizeFull();

        // Load info from the Info API endpoint
        RestTemplate restTemplate = new RestTemplate();
        String info = restTemplate.getForObject("http://localhost:8080/api/info", String.class);

        infoArea.setValue(info);
        infoArea.setReadOnly(true);

        add(infoArea);
    }
}
