package com.example.simpledms.service;

import com.example.simpledms.model.Todo;
import com.example.simpledms.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : TodoService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    //    전체 조회 함수
    public List<Todo> findAll() {
        List<Todo> list = todoRepository.findAll();

        return list;
    }

    //   전체 삭제 함수
    public void removeAll() {
        todoRepository.deleteAll(); // 전체 삭제
    }

    //   정보 저장/수정 함수
    public Todo save(Todo todo) {

        Todo todo2 = todoRepository.save(todo);

        return todo2;
    }

    //    다이어리 번호로 조회하는 함수
    public Optional<Todo> findByTno(int tno) {
//        findById(기본키속성)
        Optional<Todo> optionalTodo = todoRepository.findById(tno);

        return optionalTodo;
    }

    // 번호(dno)로 삭제하는 함수
    public boolean removeById(int tno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(todoRepository.existsById(tno) == true) {
            todoRepository.deleteById(tno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }



    //    다이어리 조회하는 함수
    public List<Todo> findByUserId(Long id) {
        List<Todo> list = todoRepository.findByUserId(id);

        return list;
    }


}









