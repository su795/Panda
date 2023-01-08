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
 * fileName : Mb
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_MB")
@SequenceGenerator(
        name= "SQ_MB_GENERATOR"
        , sequenceName = "SQ_MB"
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
@SQLDelete(sql="UPDATE TB_MB SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE MNO = ?")
public class Mb extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_MB_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer mno;

    @Column(columnDefinition = "VARCHAR2")
    private String nick;

    @Column(columnDefinition = "VARCHAR2")
    private String mbTitle;

    @Column(columnDefinition = "VARCHAR2")
    private String mbContent;

    @Column(columnDefinition = "NUMBER")
    private Integer mbCnt;

    @Column(columnDefinition = "VARCHAR2")
    private String mbCategory;

    @Column(columnDefinition = "NUMBER")
    private Integer mbRcnt;

    @Column(columnDefinition = "NUMBER")
    private Integer mbLike;

    @Column(columnDefinition = "VARCHAR2")
    private String mbTag;

    //    이미지 파일명
    @Column
    private String fileName;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] blobFile;

}
