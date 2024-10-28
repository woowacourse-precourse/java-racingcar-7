package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars;
    int tryNum;

    public RacingGame(String[] carNames,int tryNum){
        this.cars = createCars(carNames);
        this.tryNum = tryNum;
    }

    public List<Car> createCars(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames){
            cars.add(new Car(name));
        }
        return cars;
    }

    public void play(){
        for (int i = 0; i < tryNum; i++){
            race();
            printCurrentRaceStatus();
        }
    }
}
