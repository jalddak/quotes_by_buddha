package toy.buddha.admin.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AdminRepository {
    private static Map<Long, Admin> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Admin save(Admin admin) {
        if (findByUsername(admin.getUsername()).isPresent()) {
            return null;
        }

        admin.setId(++sequence);
        store.put(admin.getId(), admin);
        return admin;
    }

    public Admin findById(Long id) {
        return store.get(id);
    }

    public List<Admin> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Admin> findByUsername(String username) {

        return findAll().stream()
                .filter(admin -> admin.getUsername().equals(username))
                .findFirst();
    }

    public void clearStore() {
        store.clear();
    }
}
