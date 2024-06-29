package com.aash.SecondSpring.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll(Long companyId);

    Review findReviewById(Long companyId, Long reviewId);

    boolean postReview(Long companyId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review params);
}
