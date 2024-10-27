package racingcar;

public enum GameSettings {

    MAX_RANDOM_NUMBER(9),
    MIN_RANDOM_NUMBER(0);

    private final int number;

    GameSettings(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
