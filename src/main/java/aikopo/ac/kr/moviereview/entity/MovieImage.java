package aikopo.ac.kr.moviereview.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "movie")
public class MovieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String uuid;
    private String imageName;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
