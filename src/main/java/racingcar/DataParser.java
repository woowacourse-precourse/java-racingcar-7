package racingcar;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static List<RacingCar> createRacingCar(String inputName) {
        List<String> namelist = List.of(inputName.split(","));
        List<RacingCar> racingCarList = new ArrayList<>();

        for (String name : namelist) {
            RacingCar racingCar = new RacingCar(name.trim());
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }
}
