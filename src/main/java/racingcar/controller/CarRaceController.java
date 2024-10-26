package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private enum CarCountBoundary{
        MIN_CAR_COUNT(2),
        MAX_CAR_COUNT(100);

        final private int message;

        public int getMessage(){
            return message;
        }

        CarCountBoundary(int message) {
            this.message = message;
        }
    }
    private final List<Car> playCars;


    public CarRaceController(List<String> carsName){
        playCars = setCars(carsName);
        checkMinMAXCarCount();
    }


    private List<Car> setCars(List<String> carsName){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carsName.size(); i++){
            cars.add(new Car(carsName.get(i)));
        }
        return cars;
    }
    private void checkMinMAXCarCount(){
        if(playCars.size() < CarCountBoundary.MIN_CAR_COUNT.getMessage()) throw new IllegalArgumentException("경주에 필요한 최소 차량이 부족합니다.");
        if(playCars.size() > CarCountBoundary.MAX_CAR_COUNT.getMessage()) throw new IllegalArgumentException("경주에 사용되는 차량이 너무 많습니다.");
    }
    private int getRandomSingleDigit(){
        return Randoms.pickNumberInRange(0, 9);
    }
    private boolean checkStepForward(int randomDigit){
        if(randomDigit >= 4) return true;
        return false;
    }

    public void playRaceOnce(){
        for (Car car : playCars) {
            if(checkStepForward(getRandomSingleDigit())){
                car.nextStep();
            }
        }
    }
}