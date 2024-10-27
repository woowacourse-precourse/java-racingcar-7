package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.RaceLog;
import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;

public class RaceServiceImpl implements RaceService{
    private final CarRepository carRepository;

    private RaceServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private static class Holder {
        private static final RaceServiceImpl INSTANCE = new RaceServiceImpl(InMemoryCarRepository.getInstance());
    }

    public static RaceService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void setRaceCars(String carNameInput) {
        Arrays.stream(carNameInput.split(","))
                .map(Car::new)
                .forEach(carRepository::save);
    }

    @Override
    public List<RaceLog> runRaceRounds(int round) {
        List<Car> cars = carRepository.findAll();

        return IntStream.range(0, round)
                .mapToObj(i -> {
                    cars.forEach(Car::tryMove);
                    return new RaceLog(new ArrayList<>(cars));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> generateWinners() {
        return null;
    }
}
