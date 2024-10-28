package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.repository.RacingCarRepository;

import java.util.Collection;

public class RacingCarService {

    private final RacingCarRepository racingCarRepository;



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
