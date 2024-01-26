package toy.buddha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    @GetMapping("/")
    public String welcome() {
        return "service/before";
    }

    @GetMapping("/home")
    public String home() {
        return "service/before";
    }

    @GetMapping("/quote")
    public String quote() {
        return "service/after";
    }
}
