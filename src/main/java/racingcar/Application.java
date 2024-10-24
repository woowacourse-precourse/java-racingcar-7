package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println(IOMessage.INPUT_CAR_NAMES);
        String carNames = readLine();

        System.out.println(IOMessage.INPUT_TRY_COUNT);
        String tryCount = readLine();
    }
}
