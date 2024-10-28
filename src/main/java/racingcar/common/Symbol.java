package racingcar.common;

public enum Symbol {
    SEPARATE_MARKER(","),
    POSITION_MARKER("-");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

