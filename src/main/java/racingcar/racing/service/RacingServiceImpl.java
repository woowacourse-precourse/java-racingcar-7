package racingcar.racing.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.global.annotation.Service;
import racingcar.racing.domain.Car;
import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.dto.response.RacingResponseDTO;

@Service
public class RacingServiceImpl implements RacingService {

    @Override
    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        List<Car> cars = racingRequestDTO.carNames()
                .stream().map(Car::new)
                .toList();

        IntStream.range(0, racingRequestDTO.round()).forEach(round ->
                cars.forEach(car ->
                        car.move(randomMove())
                )
        );
        setWinners(cars);

        return RacingResponseDTO.from(cars, racingRequestDTO.round());
    }

    private Integer randomMove() {
        return Boolean.compare(4 <= Randoms.pickNumberInRange(0, 9), false);
    }

    private void setWinners(List<Car> cars) {
        int maxPosition = cars
                .stream().mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
        cars
                .stream().filter(car -> car.getPosition() == maxPosition)
                .forEach(Car::setWinner);
    }
}
