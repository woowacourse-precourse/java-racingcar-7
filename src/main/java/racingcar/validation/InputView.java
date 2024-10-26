package racingcar.validation;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarsName = Console.readLine();
        return inputCarsName;
    }

    public int inputCarRacingRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputCarRacingRepeatCount = Integer.parseInt(Console.readLine());
        return inputCarRacingRepeatCount;
    }
}
