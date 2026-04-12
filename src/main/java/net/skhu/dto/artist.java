package net.skhu.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class artist {
	private Long artistId;
    private String name;
    private String bio;
    private String imageUrl;
    //private LocalDateTime createdAt;
    //private LocalDateTime updatedAt;
}
