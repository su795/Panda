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
@Table(name = "TB_GOOD_REPLY")
@SequenceGenerator(
        name = "SQ_GOOD_REPLY_GENERATOR"
        , sequenceName = "SQ_GOOD_REPLY"
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
@SQLDelete(sql="UPDATE TB_GOOD_REPLY SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE REPLY_ID = ?")
public class GoodReply extends BaseTimeEntity{
//    REPLY_ID NUMBER NOT NULL PRIMARY KEY,
//    GOODS_ID NUMBER,
//    NICK VARCHAR2(1000),
//    COMM VARCHAR2(1000),

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_GOOD_REPLY_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer replyId;
    @Column(columnDefinition = "NUMBER")
    private Integer goodsId;
    @Column(columnDefinition = "NUMBER")
    private Integer commentId;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String nick;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String reply;
}
