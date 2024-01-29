package toy.buddha.domain;

public enum SortType {

    RECENT("최신순"), OLD("오래된순");

    private final String description;

    SortType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
