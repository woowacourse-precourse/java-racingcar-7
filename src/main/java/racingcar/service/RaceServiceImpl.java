package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.config.RaceConstants;
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

    public static RaceService createNewInstance() {
        return new RaceServiceImpl(InMemoryCarRepository.createNewInstance());
    }

    @Override
    public void setRaceCars(String carNameInput) {
        Arrays.stream(carNameInput.split(","))
                .map(this::validateNameAndCreatCar)
                .forEach(carRepository::save);
    }

    private Car validateNameAndCreatCar(String name) {
        validateCarName(name);
        return new Car(name);
    }

    @Override
    public List<RaceLog> executeRaceRounds(int round) {
        List<Car> cars = carRepository.findAll();

        return IntStream.range(0, round)
                .mapToObj(i -> executeRaceRound(cars))
                .collect(Collectors.toList());
    }

    private RaceLog executeRaceRound(List<Car> cars) {
        cars.forEach(Car::tryMove);
        return new RaceLog(List.copyOf(cars));
    }

    @Override
    public List<Car> generateWinners() {
        return carRepository.findWinners();
    }

    private void validateCarName(String name) {
        validateNameLength(name);
        validateNameDuplication(name);
    }

    private void validateNameLength(String name) {
        if(name.length() > RaceConstants.CAR_NAME_THRESHOLD) {
            carRepository.reset();
            throw new IllegalArgumentException();
        }
    }

    private void validateNameDuplication(String name) {
        if(!carRepository.findByName(name).isEmpty()) {
            carRepository.reset();
            throw new IllegalArgumentException();
        }
    }
}
