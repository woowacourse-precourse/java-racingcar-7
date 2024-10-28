package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RaceSystem;

import java.util.List;

import static racingcar.constants.ErrorMessage.RACE_TIME_FORMAT_ERROR_MESSAGE;
import static racingcar.constants.SystemMessage.INPUT_CAR_NAMES_MESSAGE;
import static racingcar.constants.SystemMessage.INPUT_RACE_TIME_MESSAGE;

public class Application {

    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String inputNames = Console.readLine();
        List<String> carNames = List.of(inputNames.split(DELIMITER));

        System.out.println(INPUT_RACE_TIME_MESSAGE);
        String inputRaceTime = Console.readLine();
        int raceTime;
        try {
            raceTime = Integer.parseInt(inputRaceTime);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_TIME_FORMAT_ERROR_MESSAGE);
        }

        RaceSystem raceSystem = new RaceSystem(carNames, raceTime);
        String result = raceSystem.startRace();
        System.out.println(result);
    }
}
