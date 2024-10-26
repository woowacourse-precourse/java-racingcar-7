package racingcar.view;

import java.util.List;

public class OutputView {
    public static void racingcarOutputView(List<String> carsLocation) {
        for (String oneCarLocation : carsLocation) {
            System.out.println(oneCarLocation);
        }
    }
}
