소프캡스톤디자인 Project Palette – 202014064 은정민 / 프로젝트 설정 및 웹 구조, db구조 설명
------------------------------------------------------------------------------------------------------------------------------------------------------
2026-04-01 -> 프로젝트 생성, application.properties 수정, pom.xml 의존성 추가

프로젝트 생성 설정
1.	프로젝트명: Palette
2.	Spring Boot Version 4.0.5 / Java21, maven, jar
3.	Spring Boot DevTools, Spring Web, Lombok, Validation, MyBatis Framework, Thymeleaf, MySQL Driver, Spring Security, OAuth2 Client

2026-04-05 -> git remote repository 생성, local repository 생성, repository 연결
Git URL -> https://github.com/dmswjdals112-commit/Project_Palette.git

2026-04-05 -> 웹 사이트 페이지 정의
1.	메인 페이지(로그인/회원가입 버튼, 검색 기능, 검색된 음원 플레이 리스트에 추가 기능, 마이페이지 버튼, 플레이 리스트 버튼)
2.	검색 페이지
3.	로그인 페이지(아이디, 비밀번호 입력 폼, 로그인 버튼)
4.	회원가입 페이지(사용자 닉네임, 아이디, 비밀번호 입력 폼, 회원가입 버튼)
5.	마이 페이지 (사용자 닉네임, 아이디, 비밀번호 수정 기능, 플레이 리스트 버튼
6.	플레이 리스트 페이지(플레이 리스트 생성 및 수정 기능, 음원 재생 기능(재생/일시정지, 음량조절, 반복모드, 재생 음원 이동 버튼, 메인페이지 back 버튼, 음원 목록 기능

2026-04-05 -> PaletteDB 생성 13개 테이블, 추후 테이블 삭제 및 수정 예정
[테이블 표]
Users   	사용자 -> O
UserPreferences 	사용자 설정 -> O
Artists 	아티스트 -> O
Albums  	앨범 -> O
Songs  	음원 -> O
Lyrics    	가사 
SyncedLyrics  	시간 싱크 가사
Playlists  	플레이리스트 -> O
PlaylistSongs  	플레이리스트-음원 -> O
PlayHistory    	재생 기록
Favorites	 찜한 음원
SongStats 	음원 통계
UserRecommendations	추천 음원

2026-04-26 -> war -> jar로 변경 / pom.xml 수정 / maven 삭제 후 재생성
