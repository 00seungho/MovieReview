package aikopo.ac.kr.moviereview.repository;

import aikopo.ac.kr.moviereview.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMemberTest() {
        IntStream.rangeClosed(1,100).forEach(i->{
            Member member = Member.builder()
                    .email("r"+1+"@kopo.ac.kr")
                    .pw("1234")
                    .nickname("review"+i)
                    .build();
            memberRepository.save(member);
        });


    }
    @Test
    @Commit
    public void testDeleteMember(){
        Long mid = 1L;
        Member member = Member.builder()
                .mid(mid)
                .build();

        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }
}
