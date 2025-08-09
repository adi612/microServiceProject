package com.example.auth_service.controller;

import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/demo")
@Tag(name = "Demo API")
public class DemoController {

    @GetMapping("/public")
    @Operation(summary = "Public Endpoint")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    
    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Operation(summary = "Admin Endpoint", description = "Accessible only to ROLE_ADMIN users")
    public String adminEndpoint() {
        return "This is an ADMIN-only endpoint.";
    }
}
