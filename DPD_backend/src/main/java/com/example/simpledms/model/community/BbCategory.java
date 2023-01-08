package com.example.simpledms.model.community;


import com.example.simpledms.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * packageName : com.example.simpledms.model
 * fileName : BbCategory
 * author : Ds
 * date : 2022/07/28
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/07/28         Ds          최초 생성
 */
@Entity(name="TB_BB_CATEGORY")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
// soft delete
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql = "UPDATE TB_BB_CATEGORY SET DELETE_YN = 'Y', DELETE_TIME=TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE BB_CID = ?")
public class BbCategory extends BaseTimeEntity {

    @Id
    @Column
    private String bbCid;

    // 자유게시판 카테고리 제목
    @Column
    private String bbCtitle;

    //    생성일시
    @Column
    private String insertTime;

    //    삭제여부
    @Column
    private String deleteYn;

    //    삭제일시
    @Column
    private String deleteTime;
}
