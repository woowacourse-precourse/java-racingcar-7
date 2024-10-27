package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class RacingManager {
    public List<Car>parseCarNamesToCar(String carNames){
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveOrStop(List<Car>carList){
        for(Car car : carList){
            car.move(pickNumberInRange(0,9));
        }
    }

}
