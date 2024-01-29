package toy.buddha.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuoteSaveDto {
    @NotBlank
    private String content;
}
