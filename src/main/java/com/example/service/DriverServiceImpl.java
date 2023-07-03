package com.example.service;

import com.example.model.Driver;
import com.example.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Driver> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Driver> findAllByTeam(String team) {
        Objects.requireNonNull(team);
        return this.repository.findAllByTeamIgnoreCase(team);
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<Driver> findByNumber(Integer number) {

        return this.repository.findByNumber(number);
    }

    @Override
    public Driver save(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void deleteByNumber(Integer number) {
        this.repository.deleteByNumber(number);
    }
}
