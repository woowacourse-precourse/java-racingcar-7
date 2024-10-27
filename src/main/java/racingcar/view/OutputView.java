package racingcar.view;

import racingcar.model.Cars;

public class OutputView {

    public static void display(Cars cars) {
        cars.getCars().forEach(car -> {
            String name = car.getName();
            int distance = car.getDistance();

            System.out.print(name + " : ");
            System.out.println("-".repeat(distance));
        });
        System.out.println();
    }
}
