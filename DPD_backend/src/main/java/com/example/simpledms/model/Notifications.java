package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : Users
 * author : ds
 * date : 2022-12-16
 * description : 알림 테이블
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         ds          최초 생성
 */
@Entity
@Table(name = "TB_NOTIFICATIONS")
@SequenceGenerator(
        name= "SQ_NOTIFICATIONS_GENERATOR"
        , sequenceName = "SQ_NOTIFICATIONS"
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
@SQLDelete(sql="UPDATE TB_NOTIFICATIONS SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE NOTIFICATIONS_ID = ?")

public class Notifications extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_NOTIFICATIONS_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer notifications_id;

    @Column(columnDefinition = "NUMBER")
    private Integer receiverId;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String message;

    @Column(columnDefinition = "CHAR(1)")
    private String readOrNot;

    @Column(columnDefinition = "VARCHAR2(100)")
    private String type;

    @Column(columnDefinition = "NUMBER")
    private Integer referenceId;

    @Column(columnDefinition = "TIMESTAMP")
    private String createAt;




}
