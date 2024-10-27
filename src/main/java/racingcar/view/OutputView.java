package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void start(){
        System.out.println("실행 결과");
    }
    public void displayRace(List<Car> cars){
        for (Car car : cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    private static String getCarStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getScore());
    }
}
