package com.logicap.ecommerce.model.repository;

import com.logicap.ecommerce.model.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends JpaRepository<Photos,Long> {
}
