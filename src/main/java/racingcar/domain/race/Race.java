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

    public static Race of(final String raceCount, final NumberGenerator randomNumberGenerator) {
        return new Race(raceCount, randomNumberGenerator);
    }

    public RaceResultDto progress(final Cars cars) {
        List<CarsResultDto> carsResultDtos = new ArrayList<>();
        while (raceCount.hasCount()) {
            carsResultDtos.add(cars.race(this));
            raceCount.decrease();
        }
        return new RaceResultDto(carsResultDtos);
    }

    public CarResultDto move(final Car car) {
        if (CAN_MOVE_NUMBER <= randomNumberGenerator.generate()) {
            car.move();
        }
        return car.getRaceResult();
    }

    public WinnersDto getWinners(final Cars cars) {
        return new WinnersDto(cars.getWinners());
    }
}
