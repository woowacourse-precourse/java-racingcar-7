package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String CAR_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String NUMBER_OF_RACE_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

    public String readCar() {
        System.out.println(CAR_INPUT_GUIDE);
        return Console.readLine();
    }

    public int readNumberOfMove() {
        System.out.println(NUMBER_OF_RACE_INPUT_GUIDE);
        return Integer.parseInt(Console.readLine());
    }
}
