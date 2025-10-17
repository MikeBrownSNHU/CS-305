package com.snhu.sslserver.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;

// Controller for computing SHA-256 checksums
@RestController
@RequestMapping("/hash")
public class HashController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("POST a JSON body to /hash to compute SHA-256");
    }

    @PostMapping
    public ResponseEntity<HashResponse> post(@RequestBody HashRequest req) throws Exception {
        String input = (req == null || req.getData() == null) ? "" : req.getData();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder(digest.length * 2);
        for (byte b : digest) {
            hex.append(String.format("%02x", b));
        }

        HashResponse response = new HashResponse(
                "SHA-256",
                input,
                hex.toString(),
                input.length(),
                Instant.now().toString()
        );

        return ResponseEntity.ok(response);
    }
}

// Request wrapper class
class HashRequest {
    private String data;

    public HashRequest() {} // default constructor for JSON

    public HashRequest(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

// Response wrapper class
class HashResponse {
    private String algorithm;
    private String input;
    private String sha256Hex;
    private int length;
    private String at;

    public HashResponse(String algorithm, String input, String sha256Hex, int length, String at) {
        this.algorithm = algorithm;
        this.input = input;
        this.sha256Hex = sha256Hex;
        this.length = length;
        this.at = at;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getInput() {
        return input;
    }

    public String getSha256Hex() {
        return sha256Hex;
    }

    public int getLength() {
        return length;
    }

    public String getAt() {
        return at;
    }
}