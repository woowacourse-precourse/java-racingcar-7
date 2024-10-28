package racingcar.util;


import racingcar.validator.RoundValidator;

public class RaceInputConverter {

    public static int setIntRound(String round) {

        RoundValidator.notNullOrEmpty(round);
        RoundValidator.noDecimalPoint(round);
        RoundValidator.isInteger(round);

        int parsedNumber = Integer.parseInt(round);

        RoundValidator.nonNegative(parsedNumber);
        RoundValidator.nonZero(parsedNumber);

        return parsedNumber;
    }

}
