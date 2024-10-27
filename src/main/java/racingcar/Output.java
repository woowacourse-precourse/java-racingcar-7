package racingcar;

import java.util.List;

public class Output {
    //    private String message;
    private final String CAR_LOCATION = "-";

    private void print(String message) {
        System.out.println(message);
    }

    public void carsStatus(List<Car> cars) {
        for (Car car : cars) {
            print(car.getName() + " : " + CAR_LOCATION.repeat(car.getLocation()));
        }
        print("\n");
    }

    public void gameResult(String result) {
        print("최종 우승자 : " + result);
    }
}
