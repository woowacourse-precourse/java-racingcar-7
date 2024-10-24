package racingcar.Model;

import java.util.ArrayList;

public class RacingCars {
    private final ArrayList<Car> racingCars = new ArrayList<>();

    public RacingCars(ArrayList<String> nameList){
        nameList.forEach(car -> racingCars.add(new Car(car)));
    }

    public void playRound() {
        simulation();
    }
    private void simulation(){
        racingCars.forEach(Car::go);
    }
}
