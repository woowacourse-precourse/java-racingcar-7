package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String carNames;
    private static int roundNumber;

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Console.readLine();
        return carNames;
    }

    public int inputRounds(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        roundNumber = Integer.parseInt(Console.readLine());
        return roundNumber;
    }

    public static String getCarNames() {
        return carNames;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }
}
