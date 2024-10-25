package racingcar.util;

public enum ConstCharacter {
    CAR_DELIMITER(','),
    CAR_DISTANCE('-'),
    LOWER_CASE_START_WITH('a'),
    LOWER_CASE_END_WITH('z'),
    UPPER_CASE_START_WITH('A'),
    UPPER_CASE_END_WITH('Z'),
    NUMBER_START_WITH('0'),
    NUMBER_END_WITH('9');


    private char character;

    ConstCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public static boolean checkInvalidCharacter(char c) {
        return c != CAR_DELIMITER.getCharacter() &&
                (c < LOWER_CASE_START_WITH.getCharacter() || c > LOWER_CASE_END_WITH.getCharacter()) &&
                (c < UPPER_CASE_START_WITH.getCharacter() || c > UPPER_CASE_END_WITH.getCharacter()) &&
                (c < NUMBER_START_WITH.getCharacter() || c > NUMBER_END_WITH.getCharacter());
    }
}
