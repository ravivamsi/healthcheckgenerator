package com.healthcheck.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/abler")
public class EnableDisableController {

    @GetMapping("/enable")
    public ResponseEntity<String> enable() {
        return ResponseEntity.ok("Enabled");
    }

    @GetMapping("/disable")
    public ResponseEntity<String> disable() {
        return ResponseEntity.ok("Disabled");
    }

    @GetMapping("/enable-all")
    public ResponseEntity<String> enableAll() {
        return ResponseEntity.ok("Enabled");
    }

    @GetMapping("/disable-all")
    public ResponseEntity<String> disableAll() {
        return ResponseEntity.ok("Disabled");
    }
    

    
}
