package racingcar.domain;

import racingcar.car.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGenerator {

    public static List<RacingCar> generateRacingCarList(String carNameListInput) {
//        List<RacingCar> racingCarList = new ArrayList<>();
//        for(String carName : carNameListInput.split(",")) {
//            racingCarList.add(new RacingCar(carName));
//        }
        return Arrays.stream(carNameListInput.split(","))
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }
}
