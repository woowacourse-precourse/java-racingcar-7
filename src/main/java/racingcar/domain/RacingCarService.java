package racingcar.domain;

import racingcar.controller.NameExtractor;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private List<RacingCar> cars = new ArrayList<>();
    private Integer number;

    public RacingCarService(String nameString,Integer number) {
        this.number = number;
        NameExtractor.extractNames(nameString).stream()
                .forEach(name -> cars.add(new RacingCar(name)));
    }
}
