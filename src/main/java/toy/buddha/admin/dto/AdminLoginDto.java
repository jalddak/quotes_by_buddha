package toy.buddha.admin.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AdminLoginDto {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
