package racingcar.Domain;

import racingcar.view.Input;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGenetator {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarGenetator(){
    }

    public RacingCar generateRacingCar(String nameOfCar){
        return new RacingCar(nameOfCar);
    }

    public List<RacingCar> generateRacingCars(){
        List<String> nameOfCars = Input.inputCarName();
        List<RacingCar> racingCars = new ArrayList<>();
        for(int i = 0 ; i < nameOfCars.size() ; i++){
            racingCars.add(generateRacingCar(nameOfCars.get(i)));
        }
        return racingCars;
    }
}