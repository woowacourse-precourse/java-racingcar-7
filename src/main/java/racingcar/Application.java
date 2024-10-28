package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Car> cars = InputView.getCarNames();
            int tryCount = InputView.getTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}