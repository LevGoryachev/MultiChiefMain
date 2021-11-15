package ru.goryachev.multichief.main.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/office")
public class OfficeController {

    @GetMapping("/")
    public ResponseEntity<List<?>> getAllUsers () {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser () {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser (@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id) {
        return null;
    }

}
