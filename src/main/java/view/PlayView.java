package view;

import model.Car;

import java.util.List;

public class PlayView {

    private boolean isFirst = true;

    public void playResult(List<Car> cars) {
        if (isFirst) {
            System.out.println("\n실행 결과");
            isFirst = false;
        }
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
