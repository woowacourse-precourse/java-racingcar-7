package racingcar.service;

public class CarService {
    String[] cars;

    public void createGame(String carNames) {
        splitCarNames(carNames);
    }

    public void splitCarNames(String carNames) {
        cars = carNames.split(",");
    }
}
