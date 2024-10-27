package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.Winners;

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

    public void displayWinners(Winners winners) {
        String winnerNames = winners.getWinnerNames();
        System.out.println(Message.FINAL_WINNER + winnerNames);
    }
}
