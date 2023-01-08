package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.BbCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BbCategoryRepository extends JpaRepository<BbCategory, String>  {
    Page<BbCategory> findAllByBbCtitleContainingOrderByInsertTimeDesc(String bbCtitle, Pageable pageable);

}
