package com.induslink.app.ui.views;

import com.induslink.app.ui.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.induslink.app.entity.Device;
import com.induslink.app.service.DeviceService;

@Route(value = "devices", layout = MainLayout.class)
public class DevicesView extends VerticalLayout {

    private final DeviceService deviceService;
    private final Grid<Device> grid = new Grid<>(Device.class);

    @Autowired
    public DevicesView(DeviceService deviceService) {
        this.deviceService = deviceService;
        setSizeFull();

        configureGrid();
        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.setColumns("id", "name", "type", "status", "location", "interfaceType");
        grid.getColumnByKey("id").setHeader("Device ID");
        grid.getColumnByKey("name").setHeader("Name");
        grid.getColumnByKey("type").setHeader("Type");
        grid.getColumnByKey("status").setHeader("Status");
    }

    private void updateList() {
        grid.setItems(deviceService.getAllDevices());
    }
}
