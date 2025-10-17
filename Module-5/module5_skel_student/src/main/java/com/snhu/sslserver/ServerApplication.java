package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
	// 10-01-2025 Mike Brown
	// Strong, collision-resistant hash algorithm
    private static final String ALGO = "SHA-256";

    // Your unique data string: includes first + last name
    private static final String DATA_STRING = "Mike Brown";

    // GET /hash -> simple HTML with data, algorithm, checksum
    @RequestMapping(value = "/hash", produces = "text/html")
    public String myHash() {
        try {
            // Create MessageDigest and compute digest of DATA_STRING
            MessageDigest md = MessageDigest.getInstance(ALGO);
            byte[] digest = md.digest(DATA_STRING.getBytes(StandardCharsets.UTF_8));

            // Convert bytes to lowercase hex
            String checksumHex = bytesToHex(digest);

            // Basic HTML output
            return new StringBuilder()
                    .append("<html><body>")
                    .append("<h2>Checksum Verification</h2>")
                    .append("<p>Data: ").append(DATA_STRING).append("</p>")
                    .append("<p>Algorithm: ").append(ALGO).append("</p>")
                    .append("<p>Checksum: ").append(checksumHex).append("</p>")
                    .append("</body></html>")
                    .toString();
        } catch (NoSuchAlgorithmException e) {
            // Defensive: SHA-256 should exist on standard JVMs
            return "<p>Error: " + e.getMessage() + "</p>";
        }
    }

    // Helper: bytes -> hex
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Character.forDigit((b >>> 4) & 0xF, 16));
            sb.append(Character.forDigit(b & 0xF, 16));
        }
        return sb.toString();
    }
}
