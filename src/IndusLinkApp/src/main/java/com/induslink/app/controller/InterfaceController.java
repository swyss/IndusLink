package com.induslink.app.controller;

import com.induslink.app.entity.Interface;
import com.induslink.app.service.InterfaceService;
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
    public ResponseEntity<Interface> createInterface(@RequestBody Interface interfaceType) {
        return new ResponseEntity<>(interfaceService.saveInterface(interfaceType), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterface(@PathVariable Long id) {
        interfaceService.deleteInterface(id);
        return ResponseEntity.noContent().build();
    }
}