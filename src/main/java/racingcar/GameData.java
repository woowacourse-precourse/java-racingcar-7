package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameData {

    private HashMap<String, Integer> cars;
    private int count;

    public HashMap<String, Integer> getCars() {
        return this.cars;
    }

    public void setCars(HashMap<String, Integer> cars) {
        this.cars = cars;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public List<String> sortKeys() {
        List<String> names = new ArrayList<>(cars.keySet());
        names.sort((o1, o2) -> cars.get(o2) - cars.get(o1));
        return names;
    }
}
