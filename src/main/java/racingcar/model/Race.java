package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    private List<Car> cars;
    private Winner winner;

    public Race(){
        cars = new ArrayList<>();
        winner = new Winner();
    }

    public void makeCars(List<String> carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName, new CarNameValidator()));
        }
    }

    public void raceCars() {
        for(Car car : this.cars){
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            car.move(randomNumber);
        }
    }

    public List<String> findWinner(){
        return this.winner.findWinner(this.cars);
    }

    public List<Car> getCars(){
        return this.cars;
    }
}
