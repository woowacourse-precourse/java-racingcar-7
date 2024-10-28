package racingcar.model.Winners;

import java.util.List;
import racingcar.model.Cars.Cars;

public class Winners {
    List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        List<Car> winner = checkWinner(cars);
        return new Winners(winner);
    }

    public List<Car> getWinners() {
        return winners;
    }

    private static List<Car> checkWinner(Cars cars) {
        int winnerLocation = cars.getMaxLocation();
        return cars.getCars().stream()
                .filter(car -> car.getCurrentLocation() == winnerLocation).toList();
    }
}
