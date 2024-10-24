package racingcar.util;

public enum ConstCharacter {
    CAR_DELIMITER(','),
    CAR_DISTANCE('-');

    private char character;

    ConstCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
