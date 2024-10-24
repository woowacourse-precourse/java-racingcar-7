package racingcar.Model;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class GameCars {
    public static final ArrayList<Car> cars=new ArrayList<>();

    public GameCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void playGame(){
        for (Car car : cars) {
            if(Randoms.pickNumberInRange(0,9)>4){
                car.ongoing();
            }
        }
    }

    public void showGameProgress(){

    }
}