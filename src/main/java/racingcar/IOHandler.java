package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOHandler {
    private final Validator validator = new Validator();

    public List<String> setRacerList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> racerList = Arrays.asList(input.split(","));
        validator.validateName(racerList);
        return racerList;
    }

    public int setRaceCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycle;
        String cycleInput = Console.readLine();
        cycle = validator.validateCycle(cycleInput);
        return cycle;
    }

    public void printRaceState(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + racingCar.getStatusToDash());
    }
    public String getWinnerList(List<String> winners) {
        return String.join(",", winners);
    }

}
