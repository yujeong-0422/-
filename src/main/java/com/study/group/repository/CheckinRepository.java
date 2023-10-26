package com.study.group.repository;

import com.study.group.entity.check_in;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinRepository extends JpaRepository<check_in, Integer> {
    Page<check_in>findByCategoryContaining(String searchKeyword, Pageable pageable);




}
