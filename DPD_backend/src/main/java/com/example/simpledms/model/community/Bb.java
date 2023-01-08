package com.example.simpledms.model.community;

import com.example.simpledms.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.simpledms.model
 * fileName : Bb
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_BB")
@SequenceGenerator(
        name= "SQ_BB_GENERATOR"
        , sequenceName = "SQ_BB"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_BB SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE BNO = ?")
public class Bb extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_BB_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer bno;

    @Column(columnDefinition = "VARCHAR2")
    private String nick;

    @Column(columnDefinition = "VARCHAR2")
    private String bbTitle;

    @Column(columnDefinition = "VARCHAR2")
    private String bbContent;

    @Column(columnDefinition = "NUMBER")
    private Integer bbCnt;

    @Column(columnDefinition = "VARCHAR2")
    private String bbCategory;

    @Column(columnDefinition = "NUMBER")
    private Integer bbRcnt;

    @Column(columnDefinition = "NUMBER")
    private Integer bbLike;

    @Column(columnDefinition = "VARCHAR2")
    private String bbTag;

    //    이미지 파일명
    @Column
    private String fileName;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] blobFile;

}
