package net.skhu.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class song {
	private Long songId;
    private String title;
    private Long artistId;
    private Long albumId;
    private Integer duration;
    private String fileUrl;
    private String imageUrl;
    private String dominantColor;
    private List<String> secondaryColors;
    private String colorMood;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
