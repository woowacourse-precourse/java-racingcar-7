package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public Race(){
    }

    public Cars raceCars(Cars cars) {
        for(Car car : cars.getCars()){
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            car.move(randomNumber);
        }
        return cars;
    }
}
