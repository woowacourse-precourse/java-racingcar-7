package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carNames = inputCarNames();
        int tryNum = inputTryNum();

        RacingGame racingGame = new RacingGame(carNames,tryNum);
        racingGame.play();

    }

    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static int inputTryNum(){
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
