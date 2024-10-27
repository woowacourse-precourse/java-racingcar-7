package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static final String WINNERS = "최종 우승자 : ";

    public static void printMidResult(Cars cars) {
        List<Car> carList = cars.getCars();

        for (Car car: carList) {
            String path = locationToString(car.getLocation());
            String name = car.getName();

            System.out.println(name + " : " + path);
        }
    }

    public static void printResult(List<String> carNames) {
        String result = String.join(", ", carNames);
        System.out.print(WINNERS);
        System.out.println(result);
    }

    private static String locationToString(int location) {
        return "-".repeat(Math.max(0, location));
    }
}
