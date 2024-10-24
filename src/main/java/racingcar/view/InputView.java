package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.request.CarCreateRequest;

public class InputView {

    public static CarCreateRequest readCars() {
        String[] names = getNames();
        int tryCount = getTryCount();
        return new CarCreateRequest(names, tryCount);
    }

    private static String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return readLine().split(",");
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Integer.parseInt(readLine());
    }

    private static String readLine() {
        return Console.readLine();
    }
}
