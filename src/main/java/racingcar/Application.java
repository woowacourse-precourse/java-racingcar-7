package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static String[] getCarNames() {
        String carNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Console.readLine();
        return splitCarNameByDelimiter(carNames);
    }

    private static int getGameCount() {
        String count;

        System.out.println("시도할 횟수는 몇 회인가요?");
        count = Console.readLine();
        return Integer.parseInt(count);
    }

    public static void main(String[] args) {
        String[] carNames;
        int gameCount;

        carNames = getCarNames();
        gameCount = getGameCount();

        // 최종 우승자 출력
    }
}
