package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String carNames = getCarNames();
        int moveCount = getMoveCount();
        System.out.println("입력받은 자동차 이름: " + carNames);
        System.out.println("입력받은 이동 횟수: " + moveCount);
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
