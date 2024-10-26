package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String displayCarNameInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine().trim();
        return carNamesInput;

    }

    public static int displayTryCountInputPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine().trim();
        return Integer.parseInt(tryCountInput);

    }


}
