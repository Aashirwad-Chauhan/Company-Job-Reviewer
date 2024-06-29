package com.aash.SecondSpring.review.implementation;

import com.aash.SecondSpring.company.Company;
import com.aash.SecondSpring.company.CompanyService;
import com.aash.SecondSpring.review.ReviewDB;
import com.aash.SecondSpring.review.Review;
import com.aash.SecondSpring.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDB repo;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewDB repo, CompanyService companyService) {
        this.repo = repo;
        this.companyService = companyService;
    }

    @Override public List<Review> findAll(Long companyId) {
        List<Review> reviews = repo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review findReviewById(Long companyId, Long reviewId) {
        List<Review> reviews= repo.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean postReview(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            repo.save(review);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.findCompanyById(companyId)!=null && repo.existsById(reviewId)){
            Review review = repo.findById(reviewId).orElse(null);
            assert review != null;
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyId, company);
            repo.deleteById(reviewId);
            return true;

        }
        else return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.findCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.findCompanyById(companyId));
            updatedReview.setId(reviewId);
            repo.save(updatedReview);
            return true;
        }
        else return false;
    }
}
