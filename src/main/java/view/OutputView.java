package view;

import model.Car;
import model.Cars;

import java.util.List;

public class OutputView {

    public void printCurrentStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(Message.WINNER_IS + String.join(", ", winners));
    }
}
