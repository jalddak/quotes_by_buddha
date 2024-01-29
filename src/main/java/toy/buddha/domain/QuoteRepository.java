package toy.buddha.domain;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class QuoteRepository {

    private static final Map<Long, Quote> store = new ConcurrentHashMap<>(); //static
    private static long sequence = 0L; //static

    public Quote save(Quote quote) {
        quote.setId(++sequence);
        store.put(quote.getId(), quote);
        return quote;
    }

    public Quote findById(Long id) {
        return store.get(id);
    }

    public List<Quote> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long quoteId, String content) {
        Quote quote = store.get(quoteId);
        quote.setContent(content);
        quote.setEditDate(LocalDateTime.now());
    }

    public void clearStore() {
        store.clear();
    }
}
