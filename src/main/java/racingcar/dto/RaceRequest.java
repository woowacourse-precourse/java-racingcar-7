package racingcar.dto;

import racingcar.model.CarList;

public record RaceRequest(String command, int iterations, CarList carList) {
    public RaceRequest(String command, Integer iterations) {
        this(command, iterations, new CarList());
    }

    public RaceRequest withCarList(CarList carList) {
        return new RaceRequest(this.command, this.iterations, carList);
    }
}
