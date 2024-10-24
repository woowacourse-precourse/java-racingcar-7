package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winners;

    public Winner(){
        winners = new ArrayList<>();
    }

    public List<String> getWinner(Cars cars) {
        List<String> winners = new ArrayList<>();
        int maxMovedNumber = -1;

        for (Car car : cars.getCars()) {
            int movedNumber = car.getMovedNumber();
            if (movedNumber > maxMovedNumber) {
                maxMovedNumber = movedNumber;
                winners.clear();
                winners.add(car.getName());
            } else if (movedNumber == maxMovedNumber) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
