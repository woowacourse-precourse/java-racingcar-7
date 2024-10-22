package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputData inputCars() {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int trialNum = Integer.parseInt(Console.readLine());

        return new InputData(carNames, trialNum);
    }
}
