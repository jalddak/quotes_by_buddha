package toy.buddha.admin.domain;

import lombok.Data;

@Data
public class Admin {
    private Long id;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
