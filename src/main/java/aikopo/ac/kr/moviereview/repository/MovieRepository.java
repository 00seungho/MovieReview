package aikopo.ac.kr.moviereview.repository;

import aikopo.ac.kr.moviereview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}