package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game = new Game(inputCarNames());
        game.start(inputLoopCnt());

    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int inputLoopCnt() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
