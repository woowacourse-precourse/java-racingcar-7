package racingcar;

import racingcar.car.CarGenerator;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();
        String[] carNames = CarGenerator.splitInputString(inputString);
        Display.printAllNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputAttemptCount = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        Display.printAttemptCount(inputAttemptCount);
    }
}
