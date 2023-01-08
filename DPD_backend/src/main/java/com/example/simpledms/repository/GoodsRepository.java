package com.example.simpledms.repository;

import com.example.simpledms.dto.GoodsDto;
import com.example.simpledms.dto.mypage.AccountBookDto;
import com.example.simpledms.model.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.repository
 * fileName : GoodsRepository
 * author : ds
 * date : 2022-12-16
 * description : JPA CRUD를 위한 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {



    // TODO : 상품 검색 함수추가 날짜 계산 수정된 쿼리!!! (2023-01-08 유슬기)
    //  상품 메인페이지 전체 조회 함수
    @Query(value = "select g.goods_id as goodsId " +
    " ,g.category as category " +
    " ,g.title " +
    " ,g.status " +
    " ,g.sell_price as sellPrice " +
    " ,g.view_count as viewCount " +
    " ,g.seller_id as sellerId "  +
            " ,case when substr(f.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(f.insert_time, 6,5)) " +
            " else (substr(f.insert_time, 11, 9)) " +
            " end as insertTime " +
    " ,g.selling_area_id" +
    " ,f.file_data as fileUrl " +
    " from tb_goods g, tb_file f" +
    " where g.goods_id = f.fid " +
            "and g.delete_yn = 'N'" +
            "and g.category like %:category% " +
            "and g.title like %:title% " +
            " order by g.goods_id desc "
            ,countQuery = "select g.goods_id as goodsId " +
            " ,g.category as category " +
            " ,g.title " +
            " ,g.status " +
            " ,g.sell_price as sellPrice " +
            " ,g.view_count as viewCount " +
            " ,g.seller_id as sellerId "  +
            " ,case when substr(f.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(f.insert_time, 6,5)) " +
            " else (substr(f.insert_time, 11, 9)) " +
            " end as insertTime " +
            " ,g.selling_area_id" +
            " ,f.file_data as fileUrl " +
            " from tb_goods g, tb_file f" +
            " where g.goods_id = f.fid " +
            "and g.delete_yn = 'N'" +
            "and g.category like %:category% " +
            "and g.title like %:title% " +
            " order by g.goods_id desc "
            ,nativeQuery = true)
    Page<GoodsDto> findGoodsMain(@Param("category") String category,
                                 @Param("title") String title,
                                 Pageable pageable);


//    메인페이지 상품진열함수
    @Query(value = "select g.goods_id as goodsId " +
    " ,g.category as category " +
    " ,g.title " +
    " ,g.status " +
    " ,g.sell_price as sellPrice " +
            " ,g.view_count as viewCount " +
            " ,g.seller_id as sellerId "  +
    " ,g.insert_time as insertTime" +
            " ,g.selling_area_id" +
            " ,f.file_data as fileUrl " +
    " from tb_goods g, tb_file f" +
    " where g.goods_id = f.fid " +
            "and g.delete_yn = 'N'" +
            " AND ROWNUM <= 40 " +
            " order by g.goods_id desc "
            ,countQuery = "select g.goods_id as goodsId" +
            " ,g.category as category" +
            " ,g.title " +
            " ,g.status " +
            " ,g.sell_price as sellPrice" +
            " ,g.view_count as viewCount " +
            " ,g.seller_id as sellerId"  +
            " ,g.insert_time as insertTime" +
            " ,g.selling_area_id" +
            " ,f.file_data as fileUrl" +
            " from tb_goods g, tb_file f" +
            " where g.goods_id = f.fid " +
            "and g.delete_yn = 'N'" +
            " AND ROWNUM <= 40 " +
            " order by g.goods_id desc "
            ,nativeQuery = true)
    Page<GoodsDto> findGoodsMainMain(Pageable pageable);

//    상품 번호로 조회 - 상품 디테일 페이지 함수
    Optional<Goods> findGoodsByGoodsId(int goodsId);

    @Query(value = "select g.goods_id as goodsId " +
            " ,g.category as category " +
            " ,g.title " +
            " ,g.sell_price as sellPrice " +
            " ,g.view_count as viewCount " +
            " ,g.seller_id as sellerId "  +
            " ,substr(g.insert_time, 11, 6) as insertTime " +
            " ,g.selling_area_id" +
            " ,f.file_data as fileUrl " +
            " from tb_goods g, tb_file f" +
            " where g.goods_id = :goodsId "
            ,nativeQuery = true)
    Optional<GoodsDto> findGoodsDetail(@Param("goodsId") int goodsId);


    // @Query, 한달전 가계부 조회
    @Query(value = "SELECT sum(g.SELL_PRICE) as sellPrice, COUNT(*) as status " +
            "FROM TB_GOODS g, TB_USER u " +
            "WHERE g.insert_time >= to_char(add_months(sysdate, -1),  'yyyy-mm-dd hh24:mi:ss') " +
            "AND g.SELLER_ID = :username " +
            "AND u.NICK = :username " +
            "AND g.STATUS LIKE '%완료'",
            nativeQuery = true)
    List<AccountBookDto> accountBook(@Param("username") String sellerId);



    // @Query, 3달전 가계부 조회
    @Query(value = "SELECT sum(g.SELL_PRICE) as sellPrice, COUNT(*) as status " +
            "FROM TB_GOODS g, TB_USER u " +
            "WHERE g.insert_time >= to_char(add_months(sysdate, -3),  'yyyy-mm-dd hh24:mi:ss') " +
            "AND g.SELLER_ID = :username " +
            "AND u.NICK = :username " +
            "AND g.STATUS LIKE '%완료'",
            nativeQuery = true)
    List<AccountBookDto> accountBook3M(@Param("username") String sellerId);

    // @Query, 6달전 가계부 조회
    @Query(value = "SELECT sum(g.SELL_PRICE) as sellPrice, COUNT(*) as status " +
            "FROM TB_GOODS g, TB_USER u " +
            "WHERE g.insert_time >= to_char(add_months(sysdate, -6),  'yyyy-mm-dd hh24:mi:ss') " +
            "AND g.SELLER_ID = :username " +
            "AND u.NICK = :username " +
            "AND g.STATUS LIKE '%완료'",
            nativeQuery = true)
    List<AccountBookDto> accountBook6M(@Param("username") String sellerId);

}