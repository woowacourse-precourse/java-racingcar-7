package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("Welcome racingcar game!");

        System.out.println("경주할 자동차 이름을 정하시오.(이름은 쉼표(,) 기준으로 구분)");

        String carName = Console.readLine();
        System.out.println(carName);

        String[] splitName = carName.split(","); // 이름은 쉼표를 기준으로 구분한다.

        // 이름은 5자 이하로 가능하며 5자 초과시 IllegalArgumentException을 발생시킨 후 애플리케이션 종료시킨다.
        for (int i = 0; i < splitName.length; i++) {
            if (splitName[i].length() > 5) {
                throw new IllegalArgumentException("5자 이하로 이름을 정하시오.");
            }
        }

    }
}
