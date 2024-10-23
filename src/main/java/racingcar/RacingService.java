package racingcar;

public class RacingService {
    private final String CAR_INPUT_DELIMITER = ",";

    public String[] convertCarInputToArray(String input) {
        return input.split(CAR_INPUT_DELIMITER);
    }
}
