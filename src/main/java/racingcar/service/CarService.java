package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarGame;

import java.util.List;

public class CarService {

    private final CarGame carGame;

    public CarService() {
        this.carGame = new CarGame();
    }

    public void addParticipant(String name){
        Car newCar = new Car(name, 0);
        carGame.addParticipant(newCar);
    }

    public void advanceCars(){
        for (Car car : carGame.getParticipants()){
            if(isAdvance()) car.increaseDistance();
            updateMaxDistance(car);
        }
    }

    public void updateMaxDistance(Car car) {
        if (car.getDistance() >= carGame.getMaxDistance()){
            carGame.updateMaxDistance(car.getDistance());
        }
    }

    protected boolean isAdvance(){
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4){
            return true;
        }
        return false;
    }

    public void updateWinners(){
        for (Car car : carGame.getParticipants()){
            if(car.getDistance() == carGame.getMaxDistance()){
                carGame.addWinner(car);
            }
        }
    }

    public List<String> getWinners(){
        return carGame.getWinners()
                .stream()
                .map(w -> w.getCarName())
                .toList();
    }

    public List<Car> getParticipants(){
        return carGame.getParticipants();
    }

    public List<String> getParticipantsName(){
        return carGame.getParticipants().stream().map(w -> w.getCarName()).toList();
    }
}
