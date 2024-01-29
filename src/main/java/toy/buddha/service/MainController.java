package toy.buddha.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toy.buddha.domain.Quote;
import toy.buddha.domain.QuoteRepository;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final QuoteRepository quoteRepository;

    @GetMapping("/")
    public String welcome() {
        return "service/before";
    }

    @GetMapping("/home")
    public String home() {
        return "service/before";
    }

    @GetMapping("/quote")
    public String quote(Model model) {
        List<Quote> quotes = quoteRepository.findAll();
        Collections.shuffle(quotes);
        model.addAttribute("quote", quotes.get(0));
        return "service/after";
    }
}
