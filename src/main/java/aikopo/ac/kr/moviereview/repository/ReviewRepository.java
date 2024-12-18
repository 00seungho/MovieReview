package aikopo.ac.kr.moviereview.repository;

import aikopo.ac.kr.moviereview.entity.Member;
import aikopo.ac.kr.moviereview.entity.Movie;
import aikopo.ac.kr.moviereview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"member"}, type= EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    void deleteByMember(Member member);
}
