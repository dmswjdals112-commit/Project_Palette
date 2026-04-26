package net.skhu.dto;

import java.util.List;
import lombok.Data;

@Data
public class SearchResult {
    private List<Song> songs;
    private List<Artist> artists;
    private List<Album> albums;
    private String searchKeyword;
}
