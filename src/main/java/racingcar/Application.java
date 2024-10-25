package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carListInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();

        CarRacing carRacing = new CarRacing(carListInput, attemptsInput);

        System.out.println("\n실행 결과");
        carRacing.race();
    }
}
