package racingcar.data;

import racingcar.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private final List<RoundData> roundData;

    public GameData() {
        this.roundData = new ArrayList<>();
    }

    public List<RoundData> getRoundData() {
        return roundData;
    }

    public void save(List<Car> cars) {
        List<Car> carsForSave = new ArrayList<>();

        for (Car car : cars) {
            carsForSave.add(new Car(car.getCarName(), car.getMoveCount()));
        }

        roundData.add(new RoundData(carsForSave));
    }
}
