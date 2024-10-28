package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.Collection;

public class RacingCarService {

    public void registerRacingCars(final Collection<RacingCar> racingCars, final Collection<String> carNames){
        carNames.forEach(carName -> racingCars.add(RacingCar.createRacingCar(carName)));
    }

    public void racingGame(Collection<RacingCar> racingCars){
        racingCars.forEach(this::race);
    }

    private void race(RacingCar racingCar){
        int number = Randoms.pickNumberInRange(0, 9);
        if(number>=4){
            racingCar.move();
        }
    }

}
