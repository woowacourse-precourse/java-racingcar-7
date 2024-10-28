package racingcar.dto;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.Cars;
import racingcar.domain.dto.CarSnapShot;

public class RoundResultDto {

    private final List<CarSnapShot> carSnapShots;

    public RoundResultDto(Cars cars) {
        this.carSnapShots = createRoundResult(cars);
    }

    private List<CarSnapShot> createRoundResult(Cars cars) {
        List<Car> carsStatus = cars.getCars();

        return carsStatus.stream()
                .map(CarSnapShot::new)
                .toList();
    }

    public List<CarSnapShot> getCarSnapShots() {
        return carSnapShots;
    }

}
