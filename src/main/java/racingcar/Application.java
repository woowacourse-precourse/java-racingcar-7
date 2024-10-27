package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] carList = Validator.checkInput(carName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempt = Integer.parseInt(Console.readLine());
        Validator.checkNum(attempt);

        System.out.println("\n실행 결과");
        RaceGame.runRacing(attempt, carList);
    }
}
