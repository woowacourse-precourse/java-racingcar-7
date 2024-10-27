package racingcar;

import java.util.List;

public class OutputView {
    public static void printCarStatus(Cars cars) {
        List<String> statuses = cars.collectAllStatuses();
        statuses.forEach(System.out::println);
        System.out.println();
    }


}
