package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOHandler {
    private final Validator validator = new Validator();

    public List<String> setRacerList() {
        String string = Console.readLine();
        return Arrays.asList(string.split(","));
    }

    public int setRaceCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycle;
        String cycleInput = Console.readLine();
        cycle = validator.validateInput(cycleInput);
        return cycle;
    }

    public void printRaceState(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + racingCar.getStatusToDash());
    }

}
