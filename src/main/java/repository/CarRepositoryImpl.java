package repository;

import java.util.Map;
import vehicle.Car;

public class CarRepositoryImpl implements VehicleRepository{
    private final Map<String, Car> carRepository;


    public CarRepositoryImpl(Map<String, Car> carRepository) {
        this.carRepository = carRepository;
    }
}
