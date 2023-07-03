package com.example.controller;

import com.example.model.Driver;
import com.example.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {

    private DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    /*
    GET http://localhost:8080/api/drivers
     */
    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    /*
    GET http://localhost:8080/api/drivers/team/ferrari
     */
    @GetMapping("/drivers/team/{team}")
    public ResponseEntity<List<Driver>> findAllByTeam(@PathVariable String team) {
        List<Driver> drivers = this.service.findAllByTeam(team);
        if (drivers.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(drivers);
    }

    /*
    GET http://localhost:8080/api/drivers/14
    */
    @GetMapping("/drivers/{number}")
    public ResponseEntity<Driver> findByNumber(@PathVariable Integer number) {
        return this.service.findByNumber(number)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    POST http://localhost:8080/api/drivers/
    */
    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if (driver.getId() != null)
            return ResponseEntity.badRequest().build();

        this.service.save(driver);
        return ResponseEntity.ok(driver);
    }

    /*
    PUT http://localhost:8080/api/drivers/
    */
    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.service.save(driver);
        return ResponseEntity.ok(driver);
    }

    /*
  DELETE http://localhost:8080/api/drivers/14
  */
    @DeleteMapping("/drivers/{number}")
    public ResponseEntity<Driver> deleteByNumber(@RequestBody Integer number) {
        this.service.deleteByNumber(number);
        return ResponseEntity.noContent().build();
    }



}
