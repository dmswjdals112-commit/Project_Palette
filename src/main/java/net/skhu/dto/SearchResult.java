package net.skhu.dto;

import java.util.List;

import lombok.Data;

@Data
public class SearchResult {
    private List<song> songs;
    private List<artist> artists;
    private List<album> albums;
    private String searchKeyword;
}
