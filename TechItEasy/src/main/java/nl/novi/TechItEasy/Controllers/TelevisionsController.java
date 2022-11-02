package nl.novi.TechItEasy.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TelevisionsController {
    @GetMapping("/televisions")
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok("television");
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok("television");
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody String type) {
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String type) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

}
