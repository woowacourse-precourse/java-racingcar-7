package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceDAO {
    private Map<String, CarVO> carDatabase = new HashMap<>();

    public void inputCar(CarVO car) {
        carDatabase.put(car.getCarName(), car);
    }

    public List<CarVO> Carlist() {
        return new ArrayList<>(carDatabase.values());
    }

    public CarVO findCarName(String name) {
        return carDatabase.get(name);
    }

}
