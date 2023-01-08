package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.LbCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LbCategoryRepository extends JpaRepository<LbCategory, String>  {
    Page<LbCategory> findAllByLbCtitleContainingOrderByInsertTimeDesc(String lbCtitle, Pageable pageable);

}
