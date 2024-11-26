package aikopo.ac.kr.moviereview.repository;


import aikopo.ac.kr.moviereview.entity.Movie;
import aikopo.ac.kr.moviereview.entity.MovieImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieImageRepository movieImageRepository;


    @Test
    public void insertMovies() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Movie movie = Movie
                    .builder()
                    .title("Movie Test"+i)
                    .build();
            movieRepository.save(movie);

            int imgCount = (int)(Math.random() * 5)+1;
            for (int j = 0; j < imgCount; j++) {
                MovieImage movieImage = MovieImage
                        .builder()
                        .uuid(UUID.randomUUID().toString())
                        .movie(movie)
                        .imageName("test"+j+".jpg")
                        .build();
                movieImageRepository.save(movieImage);
            }
        });

    }
}
