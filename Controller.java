package com.example.demo.controllerLs;

import com.example.demo.servicels.LinkShortenerService;
import com.example.demo.utils.QrCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.utils.QrCodeGenerator;

import java.net.URI;

@RestController
public class LinkShortenerController {


        @Autowired
        private LinkShortenerService service;


        // POST: create short link
        @PostMapping("/shorten")
        public String shortenUrl(@RequestBody String originalUrl) {
            return service.createShortLink(originalUrl);
        }

        // GET: redirect
        @GetMapping("/{code}")
        public ResponseEntity<Void> redirect(@PathVariable String code) {

            String originalUrl = service.getOriginalUrl(code);

            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl))
                    .build();
        }
    @GetMapping("/stats/{code}")
    public Long getClickCount(@PathVariable String code) {

        return service.getClickCount(code);
    }


    @GetMapping("/qr/{code}")
    public ResponseEntity<byte[]> generateQr(@PathVariable String code) {

        String shortUrl = "http://172.16.126.119:8080/" + code;

        byte[] qrImage = QrCodeGenerator.generateQRCode(shortUrl);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(qrImage);
    }
    }
