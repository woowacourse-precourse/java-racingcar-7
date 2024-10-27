package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.dto.CarResultDto;
import racingcar.domain.car.dto.CarsResultDto;
import racingcar.domain.race.dto.RaceResultDto;
import racingcar.domain.race.dto.WinnersDto;
import racingcar.util.NumberGenerator;

public class Race {
    private static final int CAN_MOVE_NUMBER = 4;

    private final RaceCount raceCount;
    private final NumberGenerator randomNumberGenerator;

    private Race(final String raceCount, final NumberGenerator randomNumberGenerator) {
        this.raceCount = RaceCount.from(raceCount);
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Race of(String raceCount, NumberGenerator randomNumberGenerator) {
        return new Race(raceCount, randomNumberGenerator);
    }

    public RaceResultDto progress(Cars cars) {
        List<CarsResultDto> carsResultDtos = new ArrayList<>();
        while (raceCount.hasCount()) {
            carsResultDtos.add(cars.race(this));
            raceCount.decrease();
        }
        return new RaceResultDto(carsResultDtos);
    }

    public CarResultDto move(Car car) {
        if (CAN_MOVE_NUMBER <= randomNumberGenerator.generate()) {
            car.move();
        }
        return new CarResultDto(car.getName(), car.getPosition());
    }

    public WinnersDto getWinners(Cars cars) {
        return new WinnersDto(cars.getWinners());
    }
}
