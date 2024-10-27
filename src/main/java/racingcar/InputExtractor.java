package racingcar;

import java.util.List;

public class InputExtractor {

    public static List<String> extractCarNames(String userInputCar) {

        String delimiter = ",";
        List<String> carNames = List.of(userInputCar.split(delimiter));

        return carNames;
    }

    public static int extractRound(String userInputRound) {
        try{
            int totalRounds = Integer.parseInt(userInputRound);
            validateRoundsPositive(totalRounds);
            return totalRounds;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static void validateRoundsPositive(int totalRounds) {
        if(totalRounds <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
