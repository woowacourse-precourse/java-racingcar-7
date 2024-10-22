package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {

    private static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public void start() {
        System.out.println(START_MESSAGE);
        String cars = readLine();
        System.out.println(GAME_COUNT_MESSAGE);
        int count = Integer.parseInt(readLine());
    }
}
