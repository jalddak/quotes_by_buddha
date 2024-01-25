package toy.buddha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    @GetMapping("/")
    public String welcome(){
        return "before";
    }

    @GetMapping("/home")
    public String home(){
        return "before";
    }

    @GetMapping("/quote")
    public String quote(){
        return "after";
    }
}
