package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingView {

    private static final RacingRequest racingRequest = new RacingRequest();

    public static RacingRequest getRequest() {
        inputView();
        return racingRequest;
    }

    private static void inputView() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        racingRequest.setCarNameList(Console.readLine());
        System.out.println("시도할 횟수");
        racingRequest.setMovement(Console.readLine());
    }

    private static void outputView() {

    }
}
