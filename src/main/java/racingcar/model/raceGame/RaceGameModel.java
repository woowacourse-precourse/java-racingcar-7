package racingcar.model.raceGame;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceGameModel {
    private List<Car> carList;
    private static final int PROGRESS_CONDITION = 4;

    public void initRaceGameModel(String[] names){
        setCarList();
        addToCarList(names);
    }

    public void runSingleRound(){
        for(Car car: carList){
            int random = getRandomNumber();
            updateCarProgress(car, random);
        }
    }

    public List<Car> getCarList(){
        return carList;
    }

    private void setCarList(){
        carList = new ArrayList<Car>();
    }

    private void addToCarList(String[] names){
        for(String name : names){
            Car car = new Car(name);
            carList.add(car);
        }
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    private void updateCarProgress(Car car, int random){
        if(random < PROGRESS_CONDITION){
            return;
        }
        car.updateProgress();
    }

}
