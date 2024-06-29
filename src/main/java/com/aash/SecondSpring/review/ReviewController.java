package com.aash.SecondSpring.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    ReviewService rs;

    public ReviewController(ReviewService rs) {
        this.rs = rs;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> findAll(@PathVariable Long companyId){
        return new ResponseEntity<>(rs.findAll(companyId), HttpStatus.OK );
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = rs.findReviewById(companyId, reviewId);
        if(review!=null) return new ResponseEntity<>(review, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> postReview(@PathVariable Long companyId , @RequestBody Review review){
        boolean posted = rs.postReview(companyId, review);

        if(posted) return new ResponseEntity<>("Review Posted Successfully!", HttpStatus.CREATED);
        else return new ResponseEntity<>("Company not Found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean deleted = rs.deleteReview(companyId, reviewId);

        if(deleted) return new ResponseEntity<>("Review deleted!", HttpStatus.OK);

        return new ResponseEntity<>("Review Not Found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review params){
        boolean updated = rs.updateReview(companyId, reviewId, params);

        if(updated) return new ResponseEntity<>("Review Updated!", HttpStatus.OK);

        return new ResponseEntity<>("Review Not Found!", HttpStatus.NOT_FOUND);
    }
}
