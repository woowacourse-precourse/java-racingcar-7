package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RaceSystem;

import java.util.List;

import static racingcar.constants.ErrorMessage.RACE_TIME_FORMAT_ERROR_MESSAGE;

public class Application {

    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> carNames = List.of(inputNames.split(DELIMITER));

        System.out.println("시도할 횟수는 몇 회인가요?");
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
