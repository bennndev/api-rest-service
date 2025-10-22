package com.lab10.api_rest_service.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lab10.api_rest_service.client.BankingClient;
import com.lab10.api_rest_service.dto.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Para formulario si es web
public class PublicApiController {

    @Autowired
    private BankingClient bankingClient;

    @PostMapping("/auth/register")
    public void register(@RequestBody RegisterRequest request) {
        bankingClient.register(request);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest request) {
        return bankingClient.login(request);
    }

    @PostMapping("/auth/logout")
    public void logout(@RequestHeader("Authorization") String token) {
        // Limpia y reenvía el token al servicio interno
        bankingClient.logout("Bearer " + token.replace("Bearer ", ""));
    }

    @PostMapping("/transfers")
    public Object transfer(@RequestBody TransferRequest request, 
                            @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null) token = "";
        // Limpia y reenvía el token al servicio interno
        return bankingClient.transfer(request, "Bearer " + token.replace("Bearer ", ""));
    }

    @GetMapping("/auth/transfer-form")
    public String transferForm(@RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null) token = "";
        // Limpia y reenvía el token al servicio interno
        return bankingClient.transferForm("Bearer " + token.replace("Bearer ", ""));
    }
}