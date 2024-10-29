package racingcar.model;

import racingcar.dto.CarDTO;
import racingcar.message.ExceptionCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    private final List<Car> carList;

    public Racing(final List<Car> carList) {
        this.carList = new ArrayList<>(validate(carList));
    }

    private List<Car> validate(final List<Car> carList) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (Car car : carList) {
            if (!uniqueCarNames.add(car.getName())) {
                throw new IllegalArgumentException(ExceptionCode.DUPLICATE_CAR_NAME.getDescription());
            }
        }

        return carList;
    }

    public void runRacingTurn() {
        for (final Car car : carList) {
            car.goOrStop();
        }
    }

    public List<String> computeWinner() {
        List<String> winners = new ArrayList<>();
        int fastest = 0;

        for (final Car car : this.carList) {
            CarDTO dto = car.getCarDTO();
            String name = dto.getName();
            int position = dto.getPosition();

            if (fastest == position) {
                winners.add(name);
                continue;
            }

            if (fastest < position) {
                fastest = position;
                winners.clear();
                winners.add(name);
            }
        }
        return winners;
    }
}