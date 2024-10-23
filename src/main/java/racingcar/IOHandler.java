package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOHandler {

    public List<String> setRacerList() {
        String string = Console.readLine();
        return Arrays.asList(string.split(","));
    }

    public int setRaceCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycle;
        String cycleInput = Console.readLine();
        cycle = validateInput(cycleInput);
        return cycle;
    }

    public void printRaceState(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + racingCar.getStatusToDash());
    }

    private static int validateInput(String cycleInput) {
        int cycle;
        try {
            cycle = Integer.parseInt(cycleInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return cycle;
    }
}
