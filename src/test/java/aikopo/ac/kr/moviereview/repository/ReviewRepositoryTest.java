package aikopo.ac.kr.moviereview.repository;

import aikopo.ac.kr.moviereview.entity.Member;
import aikopo.ac.kr.moviereview.entity.Movie;
import aikopo.ac.kr.moviereview.entity.MovieImage;
import aikopo.ac.kr.moviereview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertReview() {
        IntStream.rangeClosed(1,200).forEach(i -> {
            Long mno = (long)(Math.random() * 100)+1;
            Long mid = (long)(Math.random() * 100)+1;

            int grade = (int)(Math.random() * 5)+1;

            Member member = Member.builder()
                    .mid(mid)
                    .build();

            Review reviews = Review.builder()

                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade(grade)
                    .text("영화 리뷰 텍스트" + i)
                    .build();
            reviewRepository.save(reviews);
        });

    }
    @Test
    public void testGetMovieReviews(){
        Movie movie = Movie.builder()
                .mno(91L)
                .build();

        List<Review> result = reviewRepository.findByMovie(movie);
        result.forEach(review -> {
            System.out.println(review.getReviewnum() + "\t");
            System.out.println(review.getGrade()+"\t");
            System.out.println(review.getText()+"\t");
            System.out.println(review.getMember().getEmail()+"\t");
            System.out.println("-------------------------------------");
        });
    }
}
