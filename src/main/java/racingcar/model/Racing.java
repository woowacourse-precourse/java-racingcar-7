package racingcar.model;

public class Racing {
    private int tryCount;
    private Cars racingCars;

    public Racing(int tryCount, String carNames) {
        this.tryCount = tryCount;
        this.racingCars = new Cars(carNames);
    }

}
