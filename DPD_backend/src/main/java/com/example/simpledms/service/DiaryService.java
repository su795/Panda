package com.example.simpledms.service;

import com.example.simpledms.model.Diary;
import com.example.simpledms.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DiaryService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    //    전체 조회 함수
    public List<Diary> findAll() {
        List<Diary> list = diaryRepository.findAll();

        return list;
    }

    //   전체 삭제 함수
    public void removeAll() {
        diaryRepository.deleteAll(); // 전체 삭제
    }

    //   정보 저장/수정 함수
    public Diary save(Diary diary) {

        Diary diary2 = diaryRepository.save(diary);

        return diary2;
    }

    //    다이어리 번호로 조회하는 함수
    public Optional<Diary> findById(int id) {
//        findById(기본키속성)
        Optional<Diary> optionalDiary = diaryRepository.findById(id);

        return optionalDiary;
    }

    // 번호(dno)로 삭제하는 함수
    public boolean removeById(int dno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(diaryRepository.existsById(dno) == true) {
            diaryRepository.deleteById(dno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }



    //    다이어리 조회하는 함수
    public List<Diary> findByUserId(Long id) {
        List<Diary> list = diaryRepository.findByUserId(id);

        return list;
    }


}









