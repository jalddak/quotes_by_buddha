package toy.buddha.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.buddha.admin.domain.Admin;
import toy.buddha.admin.domain.AdminRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdminRepository adminRepository;

    public Admin login(String username, String password) {
        return adminRepository.findByUsername(username)
                .filter(admin -> admin.getPassword().equals(password))
                .orElse(null);
    }
}
