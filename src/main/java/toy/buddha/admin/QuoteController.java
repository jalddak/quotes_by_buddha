package toy.buddha.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import toy.buddha.domain.Quote;
import toy.buddha.domain.QuoteRepository;
import toy.buddha.domain.SortType;
import toy.buddha.dto.QuoteSaveDto;
import toy.buddha.dto.QuoteUpdateDto;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/quotes")
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteRepository quoteRepository;

    @ModelAttribute("SortTypes")
    public SortType[] itemTypes() {
        return SortType.values();
    }

    @GetMapping
    public String quotes(Model model) {
        List<Quote> quotes = quoteRepository.findAll();
        model.addAttribute("quotes", quotes);
        return "admin/quote/quotes";
    }

    @GetMapping("/{quoteId}")
    public String quoteDetail(@PathVariable Long quoteId, Model model) {
        Quote quote = quoteRepository.findById(quoteId);
        model.addAttribute("quote", quote);
        return "admin/quote/quote";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("quote", new Quote());
        return "admin/quote/addQuote";
    }

    @PostMapping("/add")
    public String addQuote(@Validated @ModelAttribute("quote") QuoteSaveDto quoteSaveDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("bindingResult: {}", bindingResult);
            return "admin/quote/addQuote";
        }


        Quote quote = new Quote(quoteSaveDto.getContent());
        Quote saveQuote = quoteRepository.save(quote);
        redirectAttributes.addAttribute("quoteId", saveQuote.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/admin/quotes/{quoteId}";
    }

    @GetMapping("/{quoteId}/edit")
    public String editForm(@PathVariable Long quoteId, Model model) {
        Quote quote = quoteRepository.findById(quoteId);
        model.addAttribute("quote", quote);
        return "admin/quote/editQuote";
    }

    @PostMapping("/{quoteId}/edit")
    public String editQuote(@PathVariable Long quoteId, @Validated @ModelAttribute("quote") QuoteUpdateDto quoteUpdateDto
            , BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("bindingResult: {}", bindingResult);
            return "admin/quote/editQuote";
        }

        quoteRepository.update(quoteId, quoteUpdateDto.getContent());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/admin/quotes/{quoteId}";


    }
}
