package toy.buddha.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Quote {
    private Long id;
    private String content;
    private LocalDateTime uploadDate;
    private LocalDateTime editDate;

    public Quote() {

    }

    public Quote(String content) {
        this.content = content;
        this.uploadDate = LocalDateTime.now();
    }
}
