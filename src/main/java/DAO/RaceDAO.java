package DAO;

import VO.CarVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceDAO {
    private final Map<String, CarVO> carDatabase = new HashMap<>();
    private int round;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

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
