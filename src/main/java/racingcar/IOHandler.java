package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOHandler {
    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_CYCLE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    private final Validator validator = new Validator();

    public List<String> setRacerList() {
        System.out.println(START_MESSAGE);
        List<String> racerList = Arrays.asList(Console.readLine().split(","));
        validator.validateName(racerList);
        return racerList;
    }

    public int setRaceCycle() {
        System.out.println(INPUT_CYCLE_MESSAGE);
        int cycle;
        String cycleInput = Console.readLine();
        cycle = validator.validateCycle(cycleInput);
        return cycle;
    }

    public void printRaceState(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + racingCar.getStatusToDash());
    }

    public void printWinner(String winner) {
        System.out.println(WINNER_MESSAGE+winner);
    }
}
