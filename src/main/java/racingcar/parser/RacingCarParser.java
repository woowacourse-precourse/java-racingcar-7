package racingcar.parser;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarParser {
    public static List<RacingCar> createRacingCarList(String inputName) {
        List<String> namelist = List.of(inputName.split(","));
        List<RacingCar> racingCarList = new ArrayList<>();

        for (String name : namelist) {
            RacingCar racingCar = new RacingCar(name.trim());
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }
}
