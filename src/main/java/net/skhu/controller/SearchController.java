package net.skhu.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.SearchResult;
import net.skhu.dto.Album;
import net.skhu.dto.Artist;
import net.skhu.dto.Song;
import net.skhu.mapper.SearchMapper;

@Controller
@RequestMapping("palette")
@Slf4j
public class SearchController {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private SearchMapper searchMapper;

    // get요청, 통합 검색 기능: mainPage에서 검색어 입력 후 enter -> searchMapper의 검색 메서드 호출, searchPage.html로 이동
    @GetMapping("search")
    public String search(@RequestParam(value="keyword", required=false) String keyword, Model model) {
        log.info("==================== 검색 시작 ====================");
        log.info("받은 키워드: {}", keyword);

        // 기본값 설정
        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "";
        }

        List<Song> songs = new java.util.ArrayList<>();
        List<Artist> artists = new java.util.ArrayList<>();
        List<Album> albums = new java.util.ArrayList<>();

        if (!keyword.trim().isEmpty()) {
            String searchKeyword = "%" + keyword + "%";
            log.info("검색 쿼리 키워드: {}", searchKeyword);

            // 곡명으로 검색
            try {
                songs = searchMapper.searchSongsByTitle(searchKeyword);
                log.info("✓ 곡 검색 성공: {} 개", songs.size());
                if (songs.size() > 0) {
                    log.info("  첫 번째 곡: {}", songs.get(0).getTitle());
                }
            } catch (Exception e) {
                log.error("✗ 곡 검색 실패: {}", e.getMessage());
                e.printStackTrace();
            }

            // 아티스트명으로 검색
            try {
                artists = searchMapper.searchArtistsByName(searchKeyword);
                log.info("✓ 아티스트 검색 성공: {} 개", artists.size());
            } catch (Exception e) {
                log.error("✗ 아티스트 검색 실패: {}", e.getMessage());
                e.printStackTrace();
            }

            // 앨범명으로 검색
            try {
                albums = searchMapper.searchAlbumsByTitle(searchKeyword);
                log.info("✓ 앨범 검색 성공: {} 개", albums.size());
            } catch (Exception e) {
                log.error("✗ 앨범 검색 실패: {}", e.getMessage());
                e.printStackTrace();
            }
        }

        // Model에 결과 추가
        model.addAttribute("songs", songs);
        model.addAttribute("artists", artists);
        model.addAttribute("albums", albums);
        model.addAttribute("keyword", keyword);

        log.info("==================== 검색 완료 ====================");
        log.info("최종 결과: 곡 {}, 아티스트 {}, 앨범 {}", songs.size(), artists.size(), albums.size());

        return "palette/searchPage";
    }
    // -----------------------------------------------------------------------

}
