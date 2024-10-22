package racingcar;



public class GameDirector {
    private final int count;
    private final CarManager manager = new CarManager();

    public GameDirector(String carNames,String count) {
        manager.add(carNames);
        this.count = Validator.validateCountIfNegative(count);
    }

    public void run() {
        manager.moveCars(this.count);
    }
}
