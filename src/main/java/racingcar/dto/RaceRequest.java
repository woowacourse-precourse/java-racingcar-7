package racingcar.dto;

import racingcar.model.CarList;

public class RaceRequest {
    private final String command;
    private final int iterations;
    private CarList carList;

    public RaceRequest(String command, Integer iterations) {
        this.command = command;
        this.iterations = iterations;
        this.carList = new CarList();
    }

    public RaceRequest(String command, int iterations, CarList carList) {
        this.command = command;
        this.iterations = iterations;
        this.carList = carList;
    }

    public CarList getCarList() {
        return carList;
    }

    public int getIterations() {
        return iterations;
    }

    public String getCommand() {
        return command;
    }

    public RaceRequest withCarList(CarList carList) {
        return new RaceRequest(this.command, this.iterations, carList);
    }
}