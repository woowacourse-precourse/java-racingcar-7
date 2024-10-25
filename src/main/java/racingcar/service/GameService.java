package racingcar.service;

import java.util.HashMap;
import racingcar.domain.Input;

public class GameService {

    private static Input input;

    public GameService(Input input) {
        GameService.input = input;
    }

    public void addCarName() {
        String[] names = input.getNames().split(",");

        HashMap<String, Integer> cars = new HashMap<>();
        for (String name : names) {
            if (cars.containsKey(name)) throw new IllegalArgumentException("중복된 이름입니다.");

            cars.put(name, 0);
        }
    }
}
