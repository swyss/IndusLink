package com.induslink.app.controller.entities;

import com.induslink.app.models.entities.Interface;
import com.induslink.app.service.entities.InterfaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interfaces")
public class InterfaceController {

    @Autowired
    private InterfaceService interfaceService;

    @GetMapping
    public List<Interface> getAllInterfaces() {
        return interfaceService.getAllInterfaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interface> getInterfaceById(@PathVariable Long id) {
        return interfaceService.getInterfaceById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Interface> createInterface(@Valid @RequestBody Interface interfaceType) {
        Interface createdInterface = interfaceService.saveInterface(interfaceType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInterface);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterface(@PathVariable Long id) {
        interfaceService.deleteInterface(id);
        return ResponseEntity.noContent().build();
    }
}
