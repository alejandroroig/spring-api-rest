package com.example.service;

import com.example.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    // READ
    List<Driver> findAll();
    List<Driver> findAllByTeam(String team);
    Optional<Driver> findById(Long id);
    Optional<Driver> findByNumber(Integer number);

    // CREATE / UPDATE
    Driver save(Driver driver);

    // Delete
    void deleteById(Long id);
    void deleteByNumber(Integer number);
}
