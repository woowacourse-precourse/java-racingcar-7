package view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {
    private static final String INPUT_RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String readCars() {
        System.out.println(INPUT_RACING_CAR_MESSAGE);
        return Console.readLine();
    }

    public String readRaceRound() {
        System.out.println(INPUT_RACING_ROUND_MESSAGE);
        return Console.readLine();
    }
}
