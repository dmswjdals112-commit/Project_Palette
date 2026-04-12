package net.skhu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.song;
import net.skhu.dto.artist;
import net.skhu.dto.album;

@Mapper
public interface MainPageMapper {
    
    // ==================== 곡(Song) 검색 ====================
    @Select("""
        SELECT * FROM songs 
        WHERE title LIKE #{keyword}
        LIMIT 100
    """)
    List<song> searchSongsByTitle(@Param("keyword") String keyword);
    
    // ==================== 아티스트(Artist) 검색 ====================
    @Select("""
        SELECT * FROM artists 
        WHERE name LIKE #{keyword}
        LIMIT 100
    """)
    List<artist> searchArtistsByName(@Param("keyword") String keyword);
    
    // ==================== 앨범(Album) 검색 ====================
    @Select("""
        SELECT * FROM albums 
        WHERE title LIKE #{keyword}
        LIMIT 100
    """)
    List<album> searchAlbumsByTitle(@Param("keyword") String keyword);
}
