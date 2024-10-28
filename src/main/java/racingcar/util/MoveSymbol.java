package racingcar.util;

public enum MoveSymbol {
    DASH("-");

    private final String symbol;

    MoveSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
