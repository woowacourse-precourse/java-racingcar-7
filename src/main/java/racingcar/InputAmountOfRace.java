package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputAmountOfRace {
    private int raceAmount;

    public void inputRaceAmount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceString = Console.readLine();

        raceAmount = Integer.parseInt(raceString);

        try {
            raceAmount = Integer.parseInt(raceString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        if (raceAmount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }


    public int getRaceAmount() {
        return raceAmount;
    }
}
