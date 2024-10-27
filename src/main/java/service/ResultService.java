package service;

import static constant.GameConstants.NAME_VALUE_FORMAT;
import static constant.GameConstants.POSITION_SYMBOL;
import static constant.GameConstants.WINNER_SEPARATOR;

import model.Car;
import repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ResultService {

    private final List<Car> cachedCars = CarRepository.getCars();

    public String displayWinners() {
        List<Car> winners = findWinners();
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR.getMessage()));
    }

    public String displayRace(List<Car> cars) {
        return cachedCars.stream()
                .map(car -> String.format(NAME_VALUE_FORMAT.getMessage(), car.getName(),
                        POSITION_SYMBOL.getMessage().repeat(car.getValue())))
                .collect(Collectors.joining("\n"));
    }

    private List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return CarRepository.getCars().stream()
                .filter(car -> car.getValue() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return CarRepository.getCars().stream()
                .mapToInt(Car::getValue)
                .max()
                .orElse(0);
    }
}
