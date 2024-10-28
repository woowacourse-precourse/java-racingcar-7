package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputAmountOfRace {
    public static void main(String[] args) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceString = Console.readLine();

        int raceAmount = Integer.parseInt(raceString);
    }
}
