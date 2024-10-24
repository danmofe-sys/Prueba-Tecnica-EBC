package com.molina.app.jpa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EndpointController {
	
// Endpoint para la secuencia de Collatz
    @PutMapping("/secuence/collatz/{input}")
    public ResponseEntity<?> getCollatzSequence(@PathVariable int input) {
        if (input <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"El numero ingresado debe ser positivo.\"}");
        }
        
        List<Integer> sequence = new ArrayList<>();
        while (input != 1) {
            sequence.add(input);
            if (input % 2 == 0) {
                input /= 2;
            } else {
                input = 3 * input + 1;
            }
        }
        sequence.add(1);
        return ResponseEntity.ok().body("{\"Secuencia_Collatz\": " + sequence + "}");
    }
 // Endpoint para FizzBuzz
    @PostMapping("/fizzbuzz/{input}")
    public ResponseEntity<?> getFizzBuzz(@PathVariable int input) {
        if (input <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"El numero ingresado debe ser positivo.\"}");
        }
        List<Object> results = new ArrayList<>();
        for (int i = 1; i <= input; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.add("FizzBuzz");
            } else if (i % 3 == 0) {
                results.add("Fizz");
            } else if (i % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(i);
            }
        }

        return ResponseEntity.ok().body("{\"fizzbuzz_results\": " + results + "}");
    }
}
        
