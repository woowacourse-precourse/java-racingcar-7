package racingcar.domain;

public class RacingCarScoreMachine {
    private final Cars cars;
    private final AttemptManager attemptManager;
    private final NumberMaker randomNumberMaker;
    private final static int FORWARDABLE_MIN_RANDOM_CRITERIA = 4;
    private final static int FORWARD_DISTANCE = 1;

    public RacingCarScoreMachine(AttemptManager attemptManager, Cars cars, NumberMaker randomNumberMaker) {
        this.attemptManager = attemptManager;
        this.cars = cars;
        this.randomNumberMaker = randomNumberMaker;
    }

    public void updateCarScore() {
        for (int i = 1; i <= attemptManager.getAttemptNumber(); i++) {
            for (Car car : cars.getCars()) {
                int randomNumber = randomNumberMaker.make();
                if (randomNumber >= FORWARDABLE_MIN_RANDOM_CRITERIA) {
                    car.updateDistance(FORWARD_DISTANCE);
                }
            }
            //todo 출력?
        }
    }
}
