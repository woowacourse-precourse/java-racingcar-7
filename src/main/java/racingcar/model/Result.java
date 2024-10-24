package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;

public class Result {

    private List<CarStatusDto> carsStatus;

    public Result(List<CarStatusDto> carsStatus) {
        this.carsStatus = carsStatus;
    }

    public String findWinner() {
        return carsStatus.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(CarStatusDto::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition() {
        return carsStatus.stream()
                .mapToInt(CarStatusDto::getPosition)
                .max()
                .getAsInt();
    }

    public List<CarStatusDto> getCarsStatus() {
        return carsStatus;
    }
}
