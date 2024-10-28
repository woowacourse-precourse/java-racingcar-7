package racingcar.constant;

public enum SymbolType {
    RESULT_POSITION("-"),
    RESULT_TOKEN(" : "),
    CAR_NAME_DELIMITER(","),
    RESULT_DELIMITER(", ");

    private final String symbol;

    SymbolType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
