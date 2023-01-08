-- 방가람 추가

INSERT INTO TB_ROLE(id, name)
VALUES (SQ_ROLE.NEXTVAL, 'ROLE_USER');
-- INSERT INTO TB_ROLE(id, name) VALUES(SQ_ROLE.NEXTVAL, 'ROLE_MODERATOR');
INSERT INTO TB_ROLE(id, name)
VALUES (SQ_ROLE.NEXTVAL, 'ROLE_ADMIN');

-- admin user 1명 최초 생성
-- id : forbob
-- password : 123456
-- email : forbob@naver.com
-- roles : ROLE_ADMIN
INSERT INTO TB_USER_ROLE
VALUES (1, 2);
-- $2a$10$FlViLb0V6eAmPX70FYNYP.FrjoGjZADtfzf6xO4qeZcnhVFfyxy8W
-- id : ekvksek
-- password : Ekvksek1@@
-- email : ekvksek@naver.com
-- roles : ROLE_ADMIN


-- TB_FB 데이터
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN, INSERT_TIME, UPDATE_TIME, DELETE_TIME )
VALUES (SQ_FB.nextval, '하이', '소식임당', '새로운 소식입니다.', 12, 'FC02', 0, 6, '#기쁨', NULL, 'N', TO_CHAR('2022-12-25 14:45:39') , NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '베베', '콘서트', '몬스타엑스 콘서트 열어라!', 44, 'FC01', 0, 22, '#몬엑', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '슬기', '붕어빵', '가야대역 붕어빵 팔아요', 50, 'FC02', 0, 30, '#붕어빵', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '세희', '몬스타엑스 1월 9일 드디어 컴백!!!', '우리 몬스타엑스가 드디어 컴백합니다.여러분~~ ', 120, 'FC01', 0, 111, '#몬엑', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '허니', '몬스타 엑스 앨범', '몬스타엑스 앨범 언제나올까요', 20, 'FC02', 0, 19, '#몬엑', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '판다', '대나무', '대나무 맛있는 곳 어딘가요?', 7, 'FC01', 0, 6, '#대나무', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '슬기', '과자', '신상 과자 추천해주세요', 18, 'FC02', 0, 9, '#과자', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '완판다', '열공', '오늘은 열공모드입니다.', 53, 'FC01', 0, 43, '#공부', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '하이', '편의점 알바', '편의점 알바 구합니다.', 61, 'FC02', 0, 56, '#알바', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '베베', '올 겨울 너무 추워요', '작년보다 훨씬 춥네요.. 빨리 봄이 왔으면 좋겠어요.', 27, 'FC01', 0, 23, '#겨울', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '슬기', '우리 동네 소식', '우리동네에 애견샵이 새로 생겨요~', 100, 'FC02', 0, 21, '#애견샵', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '세희', '다들 어떤 취미가 있나요?', '요즘 피아노 배우러 다니는데 재미있어요~', 55, 'FC01', 0, 31, '#피아노', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '허니', '우리 강아지', '우리 강아지 너무 귀여워요', 24, 'FC01', 0, 12, '#강아지', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '판다', '반찬 중에 제일 좋아하는 반찬?', '계란말이 최고예요!', 68, 'FC01', 0, 44, '#계란말이', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '슬기', '야식', '야식으로 치킨 먹는 중인데 너무 맛있어요', 44, 'FC01', 0, 15, '#치킨', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '완판다', '지하철 첫차 사람많나요?', '제목이 곧 내용입니다....', 10, 'FC01', 0, 3, '#지하철', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '완판다', '에스쿱스 잘생겼다!!', '세븐틴 에스쿱스 너무너무 잘생겼어요', 110, 'FC01', 0, 3, '#지하철', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '20지', '역시 쇼미 우승은 이영지 갓영지',
        '말모 머선일
        우리 영지 무대하는거 보셨냐구
        영지 우승하는거 당연한데 발작버튼 누르는 관종들 에휴
        본업도 잘하는데 다른것도 잘하고
        조만간 영지가 대한민국 다 먹을듯',
        133, 'FC01', 0, 67, '#이영지 #쇼미우승 #갓영지', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '뿌뿌', '세븐틴 노래 추천해주세요!!!!!',
        '쀼승관 보고 입덕해서 세븐틴 노래 찾아듣는데
        신나면서 가볍게 들을수 있는 노래 추천용
        참고로 예쁘다 같이 편한노래 좋아합니당',
        33, 'FC01', 0, 17, '#세븐틴 #세븐틴노래 ', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '먹학석사', '돌박이일 보고 대구 맛집 궁금해요',
        '몬스타엑스 돌박이일 보고 대구에 맛집이 많은거 알게됐는데
        조만간 대구 먹투어 한번 가려고 하는데 찐 로컬맛집 부탁요
        일단 육사시미는 무조건 먹을꺼구
        따로국밥 비주얼 도라이던데 제일 맛있는집 알려주세요
        아 그리고 몬스타엑스 컴백 많관부',
        123, 'FC01', 0, 68, '#몬엑 #돌박이일 #대구맛집 #대구 ', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '홍시', '야식으로 먹을수 있는 간단한 레시피 알려드립니다',
        '1. 냄비에 물을 끓인다.
        2. 냉장고에서 재료를 꺼낸다.
        3. 엄마~~~~~~~~~~~~~',
        39, 'FC01', 0, 12, '#야식 #야식레시피 #엄마사랑해 ', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '위즈덤', '괌 가시는분 질문드려용',
        '다음주 엄마랑 괌으로 여행을 가는데 혹시 아쿠아슈즈 꼭 필요한가요?
        저는 답답함걸 싫어해서 슬리퍼로 다닐생각인데 혹시나하고 물어봅니당',
        112, 'FC01', 0, 55, '#괌 #괌여행', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_FB(FNO, NICK, FB_TITLE, FB_CONTENT, FB_CNT, FB_CATEGORY, FB_RCNT, FB_LIKE, FB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_FB.nextval, '햄슷타', '톱밥 갈아주는 주기 어느정도 해야하나요?',
        '한살된 베이비 햄슷따랑 같이 사는데
        햄슷따 칭구가 너무 활동적이라서요
        자주 갈아주면 좋을것 같은데
        톱밥 갈아주는 주기 어느정도가 좋알까요',
        12, 'FC01', 0, 5, '#햄찌 #햄찌톱밥', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_FB_CATEGORY 데이터
Insert into TB_FB_CATEGORY (FB_CID, DELETE_YN, INSERT_TIME, DELETE_TIME, FB_CTITLE, UPDATE_TIME)
values ('FC01', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null, '일상', null);
Insert into TB_FB_CATEGORY (FB_CID, DELETE_YN, INSERT_TIME, DELETE_TIME, FB_CTITLE, UPDATE_TIME)
values ('FC02', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null, '소식', null);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_BB 데이터
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '하이', '헬스장 추천 받아요', '집 가까운 곳이 좋을까요? 아니면 시설이 괜찮은 곳이 좋을까요??', 28, 'BC02', 0, 14, '#헬스장', NULL,
        'N', TO_CHAR('2022-12-25 14:45:39'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '베베', '만두맛집', '완판다 만두집에 군만두가 진짜 맛있어요!! 추천해요!! ', 32, 'BC01', 0, 17, '#만두', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '슬기', '비염에 좋은거 뭐 없을까요?', '병원에 가도 소용이 없고, 효과 보신것 중에 좋은 것 있나요?', 45, 'BC02', 0, 40, '#비염', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '세희', '컷트 잘하는 미용실', '이번에 머리 자를 껀데 컷트잘하는 미용실 추천해주세요', 66, 'BC03', 0, 52, '#미용실', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '허니', '베베 병원 추천해요', '동네에서 제일 괜찮은 병원이예요~', 70, 'BC02', 0, 35, '#병원', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '판다', '디저트 카페 추천해주세요', '휘낭시에나 소금빵 맛있는 디저트 집 추천받아요!', 15, 'BC01', 0, 10, '#디저트', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '슬기', '코로나 검사', '코로나 검사 안아프게 하는 곳 있을까요?', 13, 'BC02', 0, 5, '#코로나', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '완판다', '선크림 추천해요', '바나나 보트 선크림 더운나라 갈때 최고예요. 추천합니다.', 12, 'BC03', 0, 4, '#선크림', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '하이', '비타민 추천', '비타민 추천 받아요', 20, 'BC02', 0, 10, '#비타민', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '베베', '왕대박 삼겹살 집', '왕대박 삼겹살집 오픈 행사중이예요~', 102, 'BC01', 0, 99, '#삼겹살', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '슬기', '군고구마 먹고싶어요', '군고구마 어디가면 먹을 수 있죠...', 35, 'BC01', 0, 20, '#군고구마', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '세희', '여행 갈때 원피스', '여행 갈때 입을 원피스 파란색상 괜찮을까요?', 33, 'BC03', 0, 20, '#원피스', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '허니', '몬스타 엑스 앨범', '몬스타엑스 앨범 언제나올까요', 28, 'BC02', 0, 15, '#몬엑', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '판다', '이마트 VS 홈플러스', '장 보기에 어디가 좋나요?', 40, 'BC01', 0, 20, '#마트', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '슬기', '신상 초코파이', '신상 초코파이 먹어보셨나요?? 맛이 궁금해요', 50, 'BC01', 0, 25, '#신상', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_BB(BNO, NICK, BB_TITLE, BB_CONTENT, BB_CNT, BB_CATEGORY, BB_RCNT, BB_LIKE, BB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_BB.nextval, '완판다', '면접 볼때 신을 구두', '면접 볼때 구두 몇센치가 적당한가요??', 72, 'BC03', 0, 66, '#구두', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_BB_CATEGORY 데이터
Insert into TB_BB_CATEGORY (BB_CID, DELETE_YN, INSERT_TIME, DELETE_TIME, BB_CTITLE, UPDATE_TIME)
values ('BC01', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null, '맛집', null);
Insert into TB_BB_CATEGORY (BB_CID, DELETE_YN, INSERT_TIME, DELETE_TIME, BB_CTITLE, UPDATE_TIME)
values ('BC02', 'N',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null, '건강', null);
Insert into TB_BB_CATEGORY (BB_CID, DELETE_YN, INSERT_TIME, DELETE_TIME, BB_CTITLE, UPDATE_TIME)
values ('BC03', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null, '미용', null);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_MB 데이터
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '하이', '영어스터디', '영어 회화 스터디 모집합니다. 관심있으신분들 댓글 남겨주세요.', 29, 'MC01', 0, 15, '#영어', NULL,
        'N', TO_CHAR('2022-12-25 14:45:39'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '베베', '한국사 자격증 준비하시는 분!', '한국사 작겨증 준비하시는 분들 계신가요? 같이 스터디 해요', 32, 'MC01', 0, 17, '#한국사', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '슬기', '코딩 공부 힘드신분들', '줌으로 하는 코딩테스트 스터디 모집합니다.', 45, 'MC01', 0, 40, '#코딩', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '세희', '테니스', '매주 토요일 일주일에 한번 같이 테니스 쳐요~~', 66, 'MC02', 0, 52, '#테니스', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '허니', '개인적으로 프로젝트 하시는 분 계신가요?', '팀을 모아서 미니 프로젝트를 하려고합니다. 관심있으신 분들 연락주세요.', 70, 'MC01', 0, 35,
        '#프로젝트', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '판다', '아침 수영', '해동이 센터 아침수영 사람 많나요?', 15, 'MC02', 0, 10, '#수영', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '슬기', '취업 스터디 모집합니다.', '총 인원 6명으로 최근 취업된 인원 때문에 2명 충원합니다.', 13, 'MC01', 0, 5, '#취업', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '완판다', '프랑스어 관심있으신분 있으신가요?', '프랑스어 혼자 공부하기가 힘든데.. 같이 하실분 계신가요?', 12, 'MC01', 0, 4, '#프랑스어', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '하이', '등산 좋아하시는 분!', '같이 등산 갈 인원 모집합니다!!', 20, 'MC02', 0, 10, '#등산', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '베베', '온라인 코딩테스트 인원 충원', '코딩테스트 후 모여서 리뷰하는 스터디를 할 예정입니다. 관심있는 분 댓글 남겨주세요.', 102, 'MC01', 0, 99,
        '#코테', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '슬기', '온라인 독서 토론회 함께 하실 분 모집',
        '요일과 시간은 매주 토요일 오후 9시 30분부터 시작하여 1시간 30분 정도입니다. 발제를 하고 자유롭고 심도 있는 토론을 합니다', 35, 'MC01', 0, 20, '#토론회', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '세희', '작곡이 취미이신 분 있나요?', '제가 아는 지식을 최대한 공유하는 음악 파트너로써의 레슨을 하고싶습니다.', 33, 'MC02', 0, 20, '#작곡',
        NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '허니', '정처기 자격증 스터디', '오프라인 일요일 1번 만나서 해요 (3시간정도)', 28, 'MC01', 0, 15, '#정보처리기사', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '판다', '공모전,각종 오픈소스 관련 프로젝트 취미로 하실분 모집합니다.',
        '공모전,각종 오픈소스 관련 프로젝트 취미로 하실분 모집합니다. 올해 나름데로 성과가 있어서 참여 의사 있으신 분은 댓글남겨주세요.', 40, 'MC02', 0, 20, '#공모전', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '슬기', '댄스 동호회', '매주 일요일 함께 하실 분 모집합니다.', 50, 'MC02', 0, 25, '#댄스', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_MB(MNO, NICK, MB_TITLE, MB_CONTENT, MB_CNT, MB_CATEGORY, MB_RCNT, MB_LIKE, MB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_MB.nextval, '완판다', '백앤드 재능 나누어 볼까 합니다.', '대상 : 개발자를 준비하는 분, 백앤드를 고민하는 개발자, 백앤드 공부방법이 궁금한 개발자', 72, 'MC01', 0,
        66, '#백앤드', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_MB_CATEGORY 데이터
Insert into TB_MB_CATEGORY (MB_CID, DELETE_YN, INSERT_TIME,DELETE_TIME,MB_CTITLE,UPDATE_TIME)
values ('MC01', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),null,'스터디',null);
Insert into TB_MB_CATEGORY (MB_CID, DELETE_YN, INSERT_TIME,DELETE_TIME,MB_CTITLE,UPDATE_TIME)
values ('MC02', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),null,'취미',null);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_LB 데이터
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '하이', '황토색 시바견 찾아주세요',
        '어제 늦은 오후 황토색 시바견을 잃어버렸습니다. 베이지색 하네스 차고있으며 노란색 번호표 달고있습니다. 보신분 계시면 연락주세요.', 29, 'LC01', 0, 15, '#시바견', NULL,
        'N', TO_CHAR('2022-12-25 14:45:39'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '베베', '검정 가죽무늬 가방', '지하철 2호선 벤치에서 검정 가죽무늬 가방을 발견했습니다. 역무원에게 신고했으니 주인분 찾아가세요.', 32, 'LC02', 0, 17,
        '#가죽가방', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '슬기', '마르코폴로 반지갑 주웠어요.', '판다공원 화장실에서 주웠어요. 주인분 연락주세요', 45, 'LC02', 0, 40, '#지갑', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '세희', '1004번 버스있던 노란우산', '1004번 버스 맨뒷자석에 노란색우산 두고 내리신분 우산 찾아가세요~', 66, 'LC02', 0, 52, '#우산',
        NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '허니', '곰돌이 케이스 에어팟', '신어산 등산로에서 잃어버린것 같습니다. 근처에서 곰돌이 케이스 에어팟 보신분 연락주세요.', 70, 'LC01', 0, 35,
        '#에어팟', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '판다', '링 귀걸이', '해동이 센터에서 링 귀걸이 잃어버리신분 카운트에 맡겨두었으니 찾아가세요.', 15, 'LC02', 0, 10, '#귀걸이', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '슬기', '토익 기출문제집2', '판다공원 벤치에 토익 책 두고가신분 있나요.. 있으시면 댓글 달아주세요.', 13, 'LC02', 0, 5, '#토익책', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '완판다', '교통카드 잃어버렸어요 ㅜㅜ ', '지하철 3호선에서 환승하다가 잃어버린것 같은데 학생용이구요.. 혹시 보신분 있다면 연락주세요.', 12, 'LC01', 0,
        4, '#교통카드', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '하이', '황토색 시바견 찾아주세요',
        '어제 늦은 오후 황토색 시바견을 잃어버렸습니다. 베이지색 하네스 차고있으며 노란색 번호표 달고있습니다. 보신분 계시면 연락주세요.', 29, 'LC01', 0, 15, '#시바견', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '베베', '검정 가죽무늬 가방', '지하철 2호선 벤치에서 검정 가죽무늬 가방을 발견했습니다. 역무원에게 신고했으니 주인분 찾아가세요.', 32, 'LC02', 0, 17,
        '#가죽가방', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '슬기', '마르코폴로 반지갑 주웠어요.', '판다공원 화장실에서 주웠어요. 주인분 연락주세요', 45, 'LC02', 0, 40, '#지갑', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '세희', '1004번 버스있던 노란우산', '1004번 버스 맨뒷자석에 노란색우산 두고 내리신분 우산 찾아가세요~', 66, 'LC02', 0, 52, '#우산',
        NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '허니', '곰돌이 케이스 에어팟', '신어산 등산로에서 잃어버린것 같습니다. 근처에서 곰돌이 케이스 에어팟 보신분 연락주세요.', 70, 'LC01', 0, 35,
        '#에어팟', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '판다', '링 귀걸이', '해동이 센터에서 링 귀걸이 잃어버리신분 카운트에 맡겨두었으니 찾아가세요.', 15, 'LC02', 0, 10, '#귀걸이', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '슬기', '토익 기출문제집2', '판다공원 벤치에 토익 책 두고가신분 있나요.. 있으시면 댓글 달아주세요.', 13, 'LC02', 0, 5, '#토익책', NULL,
        'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_LB(LNO, NICK, LB_TITLE, LB_CONTENT, LB_CNT, LB_CATEGORY, LB_RCNT, LB_LIKE, LB_TAG, FILE_NAME, DELETE_YN,
                  INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_LB.nextval, '완판다', '교통카드 잃어버렸어요 ㅜㅜ ', '지하철 3호선에서 환승하다가 잃어버린것 같은데 학생용이구요.. 혹시 보신분 있다면 연락주세요.', 12, 'LC01', 0,
        4, '#교통카드', NULL, 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_LB_CATEGORY 데이터
Insert into TB_LB_CATEGORY (LB_CID, DELETE_YN, INSERT_TIME,DELETE_TIME,LB_CTITLE,UPDATE_TIME)
values ('LC01','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),null,'분실',null);
Insert into TB_LB_CATEGORY (LB_CID, DELETE_YN, INSERT_TIME,DELETE_TIME,LB_CTITLE,UPDATE_TIME)
values ('LC02','N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),null,'신고',null);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TB_DIARY
VALUES (SQ_DIARY.NEXTVAL, 1, '안녕하세요', '안녕하세요! 다판다입니다.', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_DIARY
VALUES (SQ_DIARY.NEXTVAL, 2, 'ㅎㅇㅎㅇ', '안녕하세요! 다판다입니다.', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

INSERT INTO TB_TODO
VALUES (SQ_TODO.NEXTVAL, '1', '뿌스테라 시청', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_TODO
VALUES (SQ_TODO.NEXTVAL, '1', '공방 뛰기', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

----------- GOODS ---------
INSERT INTO TB_USER(ID, EMAIL, PASSWORD, USERNAME, ADDRESS, MOBILE_NUMBER, NICK,  DELETE_YN, INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_USER.nextval, 'panda@naver.com', 'panda', 'panda', '서울', '01054984988','완판다', 'N',TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') , NULL, NULL);
----------- USER ---------
INSERT INTO TB_USER(ID, EMAIL, PASSWORD, USERNAME, ADDRESS, MOBILE_NUMBER, NICK,  DELETE_YN, INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_USER.nextval, 'wonwoo@naver.com', 'wonwoo96', 'wonwoo', '서울', '01012314158','워누', 'N',TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') , NULL, NULL);
INSERT INTO TB_USER(ID, EMAIL, PASSWORD, USERNAME, ADDRESS, MOBILE_NUMBER, NICK,  DELETE_YN, INSERT_TIME, UPDATE_TIME, DELETE_TIME)
VALUES (SQ_USER.nextval, 'boo@naver.com', 'boo98', 'boo', '서울', '01098765432','뿌야', 'N',TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') , NULL, NULL);

COMMIT;


