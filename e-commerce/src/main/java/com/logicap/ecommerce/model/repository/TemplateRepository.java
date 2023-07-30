package com.logicap.ecommerce.model.repository;

import com.logicap.ecommerce.model.entity.Templates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Templates,Long> {
}
