package racingcar.view;

import java.util.Map;

public class OutputView {

    public void printExecutionResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printCarsStatus(Map<String, String> cars) {
        cars.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();
    }
}
