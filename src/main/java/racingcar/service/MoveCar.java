package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.RacingCar;
import racingcar.Domain.RacingCars;

import java.util.List;

public class MoveCar {
    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveCar(RacingCar racingCar){
        if(generateRandomNumber() >= 4){
            racingCar.moveCarPosition();
        }
    }

    public void moveCars(RacingCars racingCars){
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        racingCarList.stream()
                .forEach(this::moveCar);}
}