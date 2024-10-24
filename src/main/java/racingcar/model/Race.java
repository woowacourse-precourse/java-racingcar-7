package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {

    public Race(){
    }

    public Cars startRace(Cars cars) {
        for(Car car : cars.getCars()){
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
        return cars;
    }
}
