package com.lab10.api_rest_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.lab10.api_rest_service.dto.TransferRequest;
import com.lab10.api_rest_service.dto.RegisterRequest;
import com.lab10.api_rest_service.dto.LoginRequest;

@FeignClient(name = "user-banking-service", url = "${user-banking.url:http://user-banking-service:8081}")
public interface BankingClient {

    @PostMapping("/internal/auth/register")
    void register(@RequestBody RegisterRequest request);

    @PostMapping("/internal/auth/login")
    String login(@RequestBody LoginRequest request);

    @PostMapping("/internal/auth/logout")
    void logout(@RequestHeader("Authorization") String token);

    @PostMapping("/internal/transfers")
    Object transfer(@RequestBody TransferRequest request,
            @RequestHeader("Authorization") String token);

    @GetMapping("/internal/auth/transfer-form")
    String transferForm(@RequestHeader("Authorization") String token);
}
