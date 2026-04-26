package net.skhu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Song;
import net.skhu.dto.Artist;
import net.skhu.dto.Album;

@Mapper
public interface SearchMapper {

    @Select("""
        SELECT * FROM songs 
        WHERE title LIKE #{keyword}
        LIMIT 100
    """)
    List<Song> searchSongsByTitle(@Param("keyword") String keyword);

    @Select("""
        SELECT * FROM artists 
        WHERE name LIKE #{keyword}
        LIMIT 100
    """)
    List<Artist> searchArtistsByName(@Param("keyword") String keyword);

    @Select("""
        SELECT * FROM albums 
        WHERE title LIKE #{keyword}
        LIMIT 100
    """)
    List<Album> searchAlbumsByTitle(@Param("keyword") String keyword);
}

