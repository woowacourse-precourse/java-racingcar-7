package racingcar.domain.race.vo;

public record RoundResult(String carName, int position) {
    private static final String POSITION_SYMBOL = "-";

    public String formattedPosition() {
        return POSITION_SYMBOL.repeat(position);
    }

    @Override
    public String toString() {
        return carName + " : " + formattedPosition();
    }
}
