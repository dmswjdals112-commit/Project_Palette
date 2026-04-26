package net.skhu.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Album {
    private Long albumId;
    private String title;
    private Long artistId;
    private String releaseDate;
    private String imageUrl;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}