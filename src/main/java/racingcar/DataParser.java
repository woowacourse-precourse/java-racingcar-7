package racingcar;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static List<RacingCar> createRacingCar(String input) {
        List<String> list = List.of(input.split(","));
        List<RacingCar> racingCarList = new ArrayList<>();

        for (String s : list) {
            RacingCar racingCar = new RacingCar(s.trim());
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }
}
