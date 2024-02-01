package toy.buddha;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toy.buddha.admin.domain.Admin;
import toy.buddha.admin.domain.AdminRepository;
import toy.buddha.domain.Quote;
import toy.buddha.domain.QuoteRepository;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final QuoteRepository quoteRepository;
    private final AdminRepository adminRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        quoteRepository.save(new Quote("실패한 사람이 다시 일어나지 못하는 것은 그 마음이 교만한 까닭이다.\n성공한 사람이 그 성공을 유지하지 못하는 것도 역시 교만한 까닭이다."));
        quoteRepository.save(new Quote("우리의 모든 것은 우리가 생각한 것의 결과이다."));
        quoteRepository.save(new Quote("과거에 얽매이면 마음의 짐이 되어 고통을 준다.\n과거가 얼마나 힘들었든 간에 너는 항상 다시 시작할 수 있다."));

        Admin admin = new Admin("admin", "admin123!");
        adminRepository.save(admin);
    }

}