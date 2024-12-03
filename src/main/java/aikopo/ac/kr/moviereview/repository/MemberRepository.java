package aikopo.ac.kr.moviereview.repository;

import aikopo.ac.kr.moviereview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
