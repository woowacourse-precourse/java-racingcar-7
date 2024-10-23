package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarGame;

public class CarService {

    private final CarGame carGame;

    public CarService() {
        this.carGame = new CarGame();
    }

    public void updateAttempts(int attempts) {
        this.carGame.updateAttempts(attempts);
    }

    public void addParticipant(String name){
        Car newCar = new Car(name, 0);
        carGame.addParticipant(newCar);
    }

    public boolean isAdvance(){
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4){
            return true;
        }
        return false;
    }

}
