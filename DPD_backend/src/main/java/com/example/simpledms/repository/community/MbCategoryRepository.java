package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.MbCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MbCategoryRepository extends JpaRepository<MbCategory, String>  {
    Page<MbCategory> findAllByMbCtitleContainingOrderByInsertTimeDesc(String mbCtitle, Pageable pageable);

}
