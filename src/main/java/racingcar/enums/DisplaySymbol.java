package racingcar.enums;

public enum DisplaySymbol {
    POSITION_SYMBOL("-");

    private final String symbol;

    DisplaySymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}