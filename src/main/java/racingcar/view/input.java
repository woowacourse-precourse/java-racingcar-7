package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class input {
    public static String carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameBuffer = Console.readLine();
        return carNameBuffer;
    }

    public static String GameCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameCountBuffer = Console.readLine();
        //System.out.println(); // 가시성을 위한 한 칸 띄움 기능
        return gameCountBuffer;
    }
}
