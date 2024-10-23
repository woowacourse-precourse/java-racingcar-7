package racingcar.service;

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

}
