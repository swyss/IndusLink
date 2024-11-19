package com.induslink.app.service.entities;

import com.induslink.app.models.entities.Interface;
import com.induslink.app.repository.entities.InterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterfaceService {

    @Autowired
    private InterfaceRepository interfaceRepository;

    public List<Interface> getAllInterfaces() {
        return interfaceRepository.findAll();
    }

    public Optional<Interface> getInterfaceById(Long id) {
        return interfaceRepository.findById(id);
    }

    public Interface saveInterface(Interface interfaceType) {
        return interfaceRepository.save(interfaceType);
    }

    public void deleteInterface(Long id) {
        interfaceRepository.deleteById(id);
    }
}
