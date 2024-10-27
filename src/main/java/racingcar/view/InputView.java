package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?";

    public static String getListOfCarNames(){
        System.out.println(INPUT_CAR_MESSAGE);
        String CarNames = Console.readLine();
        return CarNames;
    }
}
