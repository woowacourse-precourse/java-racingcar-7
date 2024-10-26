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
            return totalRounds;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
