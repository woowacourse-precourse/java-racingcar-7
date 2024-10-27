package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race {
    public void runRace() {
        String racingCarsName = inputCarName(); // 자동차 이름 문자열을 입력받는다.
        int raceRound = inputRaceRound(); // 자동차 race round를 입력받는다.
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine();
    }

    public int inputRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
