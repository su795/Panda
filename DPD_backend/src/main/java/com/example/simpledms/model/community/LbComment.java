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
 * fileName : LbComment
 * author : ds
 * date : 2022-12-16
 * description : 분실게시판 댓글 model
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Entity
@Table(name = "TB_LB_COMMENT")
@SequenceGenerator(
        name = "SQ_LB_COMMENT_GENERATOR"
        , sequenceName = "SQ_LB_COMMENT"
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
@SQLDelete(sql="UPDATE TB_LB_COMMENT SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE COMMENT_ID = ?")
public class LbComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LB_COMMENT_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer commentId;
    @Column(columnDefinition = "NUMBER")
    private Integer lno;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String nick;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String comm;
}
