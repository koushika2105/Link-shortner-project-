package com.example.demo.servicels;

import com.example.demo.entity.LinkShortenerEntity;
import com.example.demo.repository.LinkShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LinkShortenerService {

    @Autowired
    private LinkShortenerRepository repository;

    // Create short URL
    public String createShortLink(String originalUrl) {

        String shortCode = generateUniqueCode();

        LinkShortenerEntity entity = new LinkShortenerEntity();
        entity.setOriginalUrl(originalUrl);
        entity.setShortCode(shortCode);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setExpiryTime(LocalDateTime.now().plusMinutes(20));

        repository.save(entity);

        return "http://localhost:8080/" + shortCode;
    }

    // Get original URL
    public String getOriginalUrl(String shortCode) {

        LinkShortenerEntity entity = repository.findByShortCode(shortCode)
                    .orElseThrow(() -> new RuntimeException("URL not found"));
        if (entity.getExpiryTime() != null &&
                entity.getExpiryTime().isBefore(LocalDateTime.now())) {

            throw new RuntimeException("Link expired");
        }


            entity.setClickCount(entity.getClickCount() + 1);


            repository.save(entity);

            return entity.getOriginalUrl();
        }
    public Long getClickCount(String shortCode) {

        return repository.findByShortCode(shortCode)
                .map(LinkShortenerEntity::getClickCount)
                .orElse(0L);
    }

    private String generateUniqueCode() {

        String code;

        do {
            code = UUID.randomUUID().toString().substring(0, 6);
        } while (repository.findByShortCode(code).isPresent());

        return code;
    }
}