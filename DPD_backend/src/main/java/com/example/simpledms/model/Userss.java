//package com.example.simpledms.model;
//
//import lombok.*;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.SQLDelete;
//import org.hibernate.annotations.Where;
//
//import javax.persistence.*;
//
///**
// * packageName : com.example.simpledms.model
// * fileName : TB_USER
// * author : ds
// * date : 2022-12-16
// * description : 유저 테이블
// * ===========================================================
// * DATE            AUTHOR             NOTE
// * —————————————————————————————
// * 2022-12-16         ds          최초 생성
// */
//@Entity
//@Table(name = "TB_USER")
//@SequenceGenerator(
//        name= "SQ_USER_GENERATOR"
//        , sequenceName = "SQ_USER"
//        , initialValue = 1
//        , allocationSize = 1
//)
//// lombok 라이브러리 어노테이션
//@Setter
//@Getter
//@ToString
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//// null 무시하고 sql 문 자동생성하는 어노테이션
//@DynamicInsert
//@DynamicUpdate
//@Where(clause = "DELETE_YN = 'N'")
//@SQLDelete(sql="UPDATE TB_USER SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE USER_ID = ?")
//
//public class Userss extends BaseTimeEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE
//            , generator = "SQ_USER_GENERATOR"
//    )
//    @Column(columnDefinition = "NUMBER")
//    private Integer userId;
//
//    @Column(columnDefinition = "VARCHAR2(1000)")
//    private Integer name;
//
//    @Column(columnDefinition = "VARCHAR2(1000)")
//    private Integer password;
//
//    @Column(columnDefinition = "VARCHAR2(1000)")
//    private String username;
//
//    @Column(columnDefinition = "VARCHAR2(1000)")
//    private String nick;
//
//    @Column(columnDefinition = "NUMBER")
//    private Integer mobileNumber;
//
//    @Column(columnDefinition = "VARCHAR2(1000)")
//    private String email;
//
//    @Column(columnDefinition = "NUMERIC(3,1)")
//    private Integer ratingScore;
//
//    @Column(columnDefinition = "TIMESTAMP")
//    private String createAt;
//
//    @Column(columnDefinition = "INT(4)")
//    private Integer sidoAreaId;
//
//    @Column(columnDefinition = "INT(4)")
//    private Integer siggAreaId;
//
//    @Column(columnDefinition = "INT(4)")
//    private Integer emdAreaId;
//
//    @Column(columnDefinition = "VARCHAR2(100)")
//    private String role;
//
//    @Column(columnDefinition = "CHAR(1)")
//    private String activated;
//
//
//}
