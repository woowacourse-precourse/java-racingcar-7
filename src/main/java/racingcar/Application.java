package racingcar;

import camp.nextstep.edu.missionutils.Console;
import Controller.RacingController;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)");
        String inputs = Console.readLine();

        System.out.println("시도할 횟수");
        String n = Console.readLine();
        RacingController rc = new RacingController();

        rc.start(inputs, n);
    }
}
