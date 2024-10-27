package racingcar.dto;

import java.util.List;
import java.util.Objects;
import racingcar.constants.StringConstants;
import racingcar.domain.car.Car;

public class LapResult implements Comparable<LapResult> {

    private final int lapNumber;
    private final List<CarStatus> carStatuses;

    public LapResult(int lapNumber, List<CarStatus> carStatuses) {
        this.lapNumber = lapNumber;
        this.carStatuses = carStatuses;
    }

    public static LapResult fromCars(int lapNumber, List<Car> cars) {
        return new LapResult(lapNumber, cars.stream().map(CarStatus::from).toList());
    }

    public static LapResult fromCarStatuses(int lapNumber, List<CarStatus> carStatuses) {
        return new LapResult(lapNumber, carStatuses);
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CarStatus carStatus : carStatuses) {
            sb.append(carStatus).append(StringConstants.NEW_LINE);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LapResult lapResult)) {
            return false;
        }
        return lapNumber == lapResult.lapNumber && Objects.equals(getCarStatuses(), lapResult.getCarStatuses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lapNumber, getCarStatuses());
    }

    @Override
    public int compareTo(LapResult o) {
        return this.lapNumber - o.lapNumber;
    }
}