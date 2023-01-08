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
@Table(name = "TB_LB")
@SequenceGenerator(
        name= "SQ_LB_GENERATOR"
        , sequenceName = "SQ_LB"
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
@SQLDelete(sql="UPDATE TB_LB SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE LNO = ?")
public class Lb extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LB_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer lno;

    @Column(columnDefinition = "VARCHAR2")
    private String nick;

    @Column(columnDefinition = "VARCHAR2")
    private String lbTitle;

    @Column(columnDefinition = "VARCHAR2")
    private String lbContent;

    @Column(columnDefinition = "NUMBER")
    private Integer lbCnt;

    @Column(columnDefinition = "VARCHAR2")
    private String lbCategory;

    @Column(columnDefinition = "NUMBER")
    private Integer lbRcnt;

    @Column(columnDefinition = "NUMBER")
    private Integer lbLike;

    @Column(columnDefinition = "VARCHAR2")
    private String lbTag;

    //    이미지 파일명
    @Column
    private String fileName;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] blobFile;

}
