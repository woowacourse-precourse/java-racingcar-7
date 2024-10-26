package racingcar.service;

import java.util.List;
import java.util.Set;
import racingcar.domain.AttemptCounter;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberMaker;

//fixme RaceMachine
public class RacingCarScoreMachine {
    private final Cars cars;
    private final AttemptCounter attemptCounter;


    private final NumberMaker randomNumberMaker;
    private final static int FORWARDABLE_MIN_RANDOM_CRITERIA = 4;
    private final static int FORWARD_DISTANCE = 1;

    public RacingCarScoreMachine(Cars cars, AttemptCounter attemptManager, NumberMaker randomNumberMaker) {
        this.cars = cars;
        this.attemptCounter = attemptManager;
        this.randomNumberMaker = randomNumberMaker;
    }

    public boolean isOverRace() {
        return attemptCounter.isEndAttempt();
    }

    public void runRace() {
        for (Car car : cars.getCars()) {
            int randomNumber = randomNumberMaker.make();
            if (randomNumber >= FORWARDABLE_MIN_RANDOM_CRITERIA) {
                car.updateDistance(FORWARD_DISTANCE);
            }
        }
        attemptCounter.decrease();
    }

    public Set<Car> getCarsNameAndDistance() {
        return cars.getCars();
    }


    /**
     * 이거를 서비스로 변경하는게 맞다. 서비스에는 중간 식 출력 최종 겨로가 출력을 하는 기능. 근데 시도 횟수만큼 for문 내부에 출력을 해야되는데, 데이터를 다 저장해두던가 아니면 for문을 컨트롤러에서
     * 해야하나? 아... 아니다. 아예 ㄱ개체 자체를 -로 낮춰버리면. 되네
     * <p>
     * public void updateCarScore() { for (int i = 1; i <= attemptManager.getAttemptNumber(); i++) { for (Car car :
     * cars.getCars()) { int randomNumber = randomNumberMaker.make(); if (randomNumber >=
     * FORWARDABLE_MIN_RANDOM_CRITERIA) { car.updateDistance(FORWARD_DISTANCE); } } //todo 출력?????여기서???????
     * Output.printIntermediateScore(cars.getCars()); } }
     */

    //todo 이름으로 넘기기
    public List<Car> getWinningCarS() {
        return cars.getWinningCar();
    }

}
