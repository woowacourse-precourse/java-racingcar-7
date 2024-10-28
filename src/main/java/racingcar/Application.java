package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
        Integer attempts = getNumberOfAttempts();
    }

    private static String[] getCarNames(){
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        return carNamesInput.split(",");
    }

    private static int getNumberOfAttempts(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
