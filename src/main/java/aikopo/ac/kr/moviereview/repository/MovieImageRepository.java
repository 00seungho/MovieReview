package aikopo.ac.kr.moviereview.repository;

import aikopo.ac.kr.moviereview.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {}