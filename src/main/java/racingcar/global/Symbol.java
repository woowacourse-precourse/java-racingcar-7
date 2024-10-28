package racingcar.global;

public enum Symbol {

    NAME_DELIMITER(",", "쉼표");

    private final String symbol;
    private final String name;

    Symbol(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String formatMessageOf(String message) {
        return String.format(message, this.name, this.symbol);
    }

    public String getSymbol() {
        return symbol;
    }
}