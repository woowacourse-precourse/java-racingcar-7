package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Vehicles;

import static racingcar.constant.ErrorMessage.RACE_ROUND_ONLY_CAN_NUMBER;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputVehicles = Console.readLine();
        Vehicles vehicles = new Vehicles(inputVehicles);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceRoundsInput = Console.readLine();

        int raceRounds = parseRaceRounds(raceRoundsInput);
        vehicles.raceStart(raceRounds);
    }

    private static int parseRaceRounds(String raceRoundsInput) {
        try {
            return Integer.parseInt(raceRoundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_ROUND_ONLY_CAN_NUMBER);
        }
    }
}