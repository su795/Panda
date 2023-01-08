package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : Goods
 * author : ds
 * date : 2022-12-16
 * description : 상품 정보 모델
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Entity
@Table(name = "TB_GOODS")
@SequenceGenerator(
        name = "SQ_GOODS_GENERATOR"
        , sequenceName = "SQ_GOODS"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql = "UPDATE TB_GOODS SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE GOODS_ID = ?")
public class Goods extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_GOODS_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer goodsId;


    @Column(columnDefinition = "VARCHAR2")
    private String category;

    @Column(columnDefinition = "VARCHAR2")
    private String sellerId;

    @Column(columnDefinition = "NUMBER")
    private Integer sellingAreaId;

    @Column(columnDefinition = "VARCHAR2(100)")
    private String title;

    @Column(columnDefinition = "VARCHAR2(30)")
    private String status;

    @Column(columnDefinition = "NUMBER")
    private Integer sellPrice;

    @Column(columnDefinition = "NUMBER")
    private Integer viewCount;

    @Column(columnDefinition = "VARCHAR2(500)")
    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private String refreshedTime;

    @Column(columnDefinition = "NUMBER")
    private String originPrice;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String tag;



}