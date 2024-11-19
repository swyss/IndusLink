package com.induslink.app.repository.entities;

import com.induslink.app.models.entities.Interface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRepository extends JpaRepository<Interface, Long> {
}
