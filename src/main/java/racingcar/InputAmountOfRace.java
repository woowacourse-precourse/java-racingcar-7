package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputAmountOfRace {
    private int raceAmount;

    public void inputRaceAmount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceString = Console.readLine();

        raceAmount = Integer.parseInt(raceString);
    }

    public int getRaceAmount() {
        return raceAmount;
    }
}
