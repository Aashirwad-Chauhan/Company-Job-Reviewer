package com.aash.SecondSpring.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDB extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}
