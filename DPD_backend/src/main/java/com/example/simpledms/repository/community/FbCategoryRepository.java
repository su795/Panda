package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.FbCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FbCategoryRepository extends JpaRepository<FbCategory, String>  {
    Page<FbCategory> findAllByFbCtitleContainingOrderByInsertTimeDesc(String fbCtitle, Pageable pageable);

}
