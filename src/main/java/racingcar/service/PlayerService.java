package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class PlayerService {

    public List<String> splitPlayer(String input) {
        List<String> players = List.of(input.split(","));
        NameValidator.validatePlayerName(players);
        return players;
    }

    public List<Car> createCarList(List<String> name) {
        List<Car> cars = new ArrayList<>();
        for (String s : name) {
            cars.add(new Car(s));
        }
        return cars;
    }
}
