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
 * fileName : Fb
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_FB")
@SequenceGenerator(
        name= "SQ_FB_GENERATOR"
        , sequenceName = "SQ_FB"
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
@SQLDelete(sql="UPDATE TB_FB SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE FNO = ?")
public class Fb extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_FB_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer fno;

    @Column(columnDefinition = "VARCHAR2")
    private String nick;

    @Column(columnDefinition = "VARCHAR2")
    private String fbTitle;

    @Column(columnDefinition = "VARCHAR2")
    private String fbContent;

    @Column(columnDefinition = "NUMBER")
    private Integer fbCnt;

    @Column(columnDefinition = "VARCHAR2")
    private String fbCategory;

    @Column(columnDefinition = "NUMBER")
    private Integer fbRcnt;

    @Column(columnDefinition = "NUMBER")
    private Integer fbLike;

    @Column(columnDefinition = "VARCHAR2")
    private String fbTag;

    //    이미지 파일명
    @Column
    private String fileName;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] blobFile;

}
