package com.example.repository;

import com.example.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findAllByTeamIgnoreCase(String team);

    Optional<Driver> findByNumber(Integer number);

    void deleteByNumber(Integer number);
}
