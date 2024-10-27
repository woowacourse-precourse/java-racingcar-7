package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        System.out.print("자동차 이름을 입력하세요 (이름은 쉼표로 구분): ");
        return Console.readLine();
    }

    public static int inputTrialCount() {
        System.out.print("시도할 횟수를 입력하세요: ");
        return Integer.parseInt(Console.readLine());
    }
}
