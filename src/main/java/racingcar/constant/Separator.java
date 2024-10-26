package racingcar.constant;

public enum Separator {
    COMMA(",");

    private final String symbol;

    Separator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
