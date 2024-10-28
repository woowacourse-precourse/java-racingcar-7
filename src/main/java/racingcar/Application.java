package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 프로그램 구현
        WoowaGoMethod woowaGoMethod = new WoowaGoMethod();
        Racing racing = new Racing(woowaGoMethod);

        System.out.println("경주할 자동차 이름들(이름은 쉼표(,) 기준으로 구분)을 입력해 주세요.");
        String carNames = Console.readLine();

        System.out.println("라운드를 입력해 주세요.");
        int round = Integer.parseInt(Console.readLine());

        racing.doRacing(carNames, round);
        Console.close();
    }
}
