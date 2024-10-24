package racingcar.util;

public enum ConstCharacter {
    CAR_DELIMITER(","),
    CAR_DISTANCE("-");

    private String character;

    ConstCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
