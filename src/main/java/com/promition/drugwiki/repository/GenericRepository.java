package com.promition.drugwiki.repository;

import com.promition.drugwiki.entity.Generic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository extends JpaRepository<Generic,Long> {
}
