package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : TB_WISHLISTS
 * author : ds
 * date : 2022-12-16
 * description : 찜 테이블
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         ds          최초 생성
 */
@Entity
@Table(name = "TB_WISHLISTS")
@SequenceGenerator(
        name= "SQ_WISHLISTS_GENERATOR"
        , sequenceName = "SQ_WISHLISTS"
        , initialValue = 1
        , allocationSize = 1
)
// lombok 라이브러리 어노테이션
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
// null 무시하고 sql 문 자동생성하는 어노테이션
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_WISHLISTS SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE WISHLISTS_ID = ?")

public class Wishlists extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_WISHLISTS_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer wishListId;

    @Column(columnDefinition = "NUMBER")
    private Integer goodsId;

    @Column(columnDefinition = "NUMBER")
    private Integer registerId;

    @Column(columnDefinition = "TIMESTAMP")
    private String createAt;

}
