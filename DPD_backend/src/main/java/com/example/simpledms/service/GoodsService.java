package com.example.simpledms.service;

import com.example.simpledms.dto.GoodsDto;
import com.example.simpledms.dto.mypage.AccountBookDto;
import com.example.simpledms.model.Goods;
import com.example.simpledms.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : GoodsService
 * author : ds
 * date : 2022-12-16
 * description :상품 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */

@Service
public class GoodsService {
    //    CRUD 함수 사용을 위한 Repository 불러오기
    @Autowired
    GoodsRepository goodsRepository;


    //    초기 상품 화면을 위한 전체 불러오기(페이징)
    public Page<Goods> findAll(Pageable pageable) {
        Page<Goods> page = goodsRepository.findAll(pageable);

        return page;
    }



    //    상품 저장 함수/수정
    public Goods save(Goods goods) {
        Goods goods2 = goodsRepository.save(goods);

        return goods2;
    }

    //    상품번호로 조회하는 함수
    public Optional<Goods> findGoodsByGoodsId(int goodsId) {
//        findById(기본키속성)
        Optional<Goods> optionalGoods = goodsRepository.findGoodsByGoodsId(goodsId);

        return optionalGoods;
    }

    // 상품번호(goodsId)로 삭제하는 함수
    public boolean removeById(int goodsId) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if (goodsRepository.existsById(goodsId) == true) {
            goodsRepository.deleteById(goodsId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }


    public Page<GoodsDto> findGoodsMain(String category, String title, Pageable pageable) {

        Page<GoodsDto> page = goodsRepository.findGoodsMain(category, title, pageable);

        return page;
    }

    public Page<GoodsDto> findGoodsMainMain(Pageable pageable) {
        Page<GoodsDto> page = goodsRepository.findGoodsMainMain(pageable);

        return page;
    }

    public Optional<GoodsDto> findGoodsDetail(int goodsId) {
        Optional<GoodsDto> optionalGoodsDto = goodsRepository.findGoodsDetail(goodsId);

        return optionalGoodsDto;
    }

    //    한달전 가계부 조회 함수
    public List<AccountBookDto> accountBook(String sellerId) {
        List<AccountBookDto> list = goodsRepository.accountBook(sellerId);

        return list;
    }


    //    3달전 가계부 조회 함수
    public List<AccountBookDto> accountBook3M(String sellerId) {
        List<AccountBookDto> list = goodsRepository.accountBook3M(sellerId);

        return list;
    }


    //    6달전 가계부 조회 함수
    public List<AccountBookDto> accountBook6M(String sellerId) {
        List<AccountBookDto> list = goodsRepository.accountBook6M(sellerId);

        return list;
    }

}