package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public GameResult play(GameResult gameResult) {
        if (gameResult == null) {
            throw new IllegalArgumentException();
        }

        List<Car> gameResultList = new ArrayList<>(gameResult.getGameResult());
        if (gameResultList.isEmpty()) {
            for (Car car : cars) {
                gameResultList.add(car.play());
            }
            return GameResult.of(gameResultList);
        }

        List<Car> gameResultList1 = new ArrayList<>();
        for (Car car : gameResultList) {
            gameResultList1.add(car.play());
        }
        return GameResult.of(gameResultList1);
    }

}
