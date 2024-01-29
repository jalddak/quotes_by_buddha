package toy.buddha.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuoteUpdateDto {

    @NotNull
    private Long id;

    @NotBlank
    private String content;

    @NotNull
    private LocalDateTime uploadDate;

    private LocalDateTime editDate;
}
