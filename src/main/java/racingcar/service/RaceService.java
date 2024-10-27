package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceService {
    private List<Car> cars;

    public RaceService() {
        this.cars = new ArrayList<>();
    }

    public void init(String input) {
        List<String> nameList = getNameList(input);
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    private static List<String> getNameList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public void race() {
        for (Car car : cars) {
            car.run(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getCars(){
        return cars;
    }
}
