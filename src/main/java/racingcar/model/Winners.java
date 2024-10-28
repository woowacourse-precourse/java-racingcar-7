package racingcar.model;

import java.util.List;

public class Winners {
    List<Car> winner;

    private Winners(List<Car> winner) {
        this.winner = winner;
    }

    public static Winners from(Cars cars) {
        List<Car> winner = checkWinner(cars);
        return new Winners(winner);
    }

    public List<Car> getWinner() {
        return winner;
    }

    private static List<Car> checkWinner(Cars cars) {
        int winnerLocation = cars.getMaxLocation();
        return cars.getCars().stream()
                .filter(car -> car.getCurrentLocation() == winnerLocation).toList();
    }
}
