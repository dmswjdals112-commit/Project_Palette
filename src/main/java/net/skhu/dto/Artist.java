package net.skhu.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Artist {
    private Long artistId;
    private String name;
    private String bio;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}