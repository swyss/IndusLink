package com.induslink.app.ui.views;

import com.induslink.app.ui.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.induslink.app.entity.Machine;
import com.induslink.app.service.MachineService;

@Route(value = "machines", layout = MainLayout.class)
public class MachinesView extends VerticalLayout {

    private final MachineService machineService;
    private final Grid<Machine> grid = new Grid<>(Machine.class);

    @Autowired
    public MachinesView(MachineService machineService) {
        this.machineService = machineService;
        setSizeFull();

        configureGrid();
        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.setColumns("id", "name", "status", "location");
        grid.getColumnByKey("id").setHeader("Machine ID");
        grid.getColumnByKey("name").setHeader("Name");
        grid.getColumnByKey("status").setHeader("Status");
        grid.getColumnByKey("location").setHeader("Location");
    }

    private void updateList() {
        grid.setItems(machineService.getAllMachines());
    }
}