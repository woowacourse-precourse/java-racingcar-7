package service;

import model.Car;
import java.util.List;

public interface RaceStatusCallback {
    void onAttempt(List<Car> cars);
}
