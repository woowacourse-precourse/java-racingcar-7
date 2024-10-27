package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarDto.CarOutputDto;
import racingcar.model.domain.Car;
import racingcar.model.domain.RacingHistory;
import racingcar.model.domain.comparator.CarMovedDistanceComparator;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingHistoryRepository;

public class RacingServiceImpl implements RacingService {
    private final CarRepository carRepository;
    private final RacingHistoryRepository racingHistoryRepository;

    public RacingServiceImpl(CarRepository carRepository, RacingHistoryRepository racingHistoryRepository) {
        this.carRepository = carRepository;
        this.racingHistoryRepository = racingHistoryRepository;
    }

    @Override
    public void startRacing(int attemptCount) {
        List<Car> carList = carRepository.findAll();

        for (int roundNumber = 0; roundNumber < attemptCount; roundNumber++) {
            runRound(carList, roundNumber);
        }
        carRepository.updateAll(carList);
    }

    private void runRound(List<Car> carList, int roundNumber) {
        for (Car car : carList) {
            race(car, roundNumber);
        }
    }

    private void race(Car car, int roundNumber) {
        boolean movable = isMovable();
        if (movable) {
            car.moveForward();
        }
        racingHistoryRepository.save(
                new RacingHistory(car.getName(), roundNumber, car.getMovedDistance()));
    }

    @Override
    public List<CarDto.CarOutputDto> selectWinner() {
        List<Car> carList = carRepository.findAll();
        carList.sort(new CarMovedDistanceComparator());
        int winnerDistance = carList.getFirst().getMovedDistance();
        return carList.stream()
                .filter(car -> car.getMovedDistance() == winnerDistance)
                .map(car -> new CarOutputDto(car.getName()))
                .collect(Collectors.toList());
    }

    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
