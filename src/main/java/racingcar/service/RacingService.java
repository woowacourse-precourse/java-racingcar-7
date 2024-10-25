package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.member.Member;
import racingcar.domain.race.Race;
import racingcar.domain.race.RaceResult;
import racingcar.dto.RaceRequestDTO;
import racingcar.dto.RaceResultDTO;
import racingcar.util.RaceRandomGenerator;

public class RacingService {

    private final RaceRandomGenerator randomGenerator;

    public RacingService(RaceRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public RaceResultDTO performRace(RaceRequestDTO raceRequestDTO) {
        List<Car> cars = convertNamesToCars(raceRequestDTO.getNames());
        Race race = new Race(cars, raceRequestDTO.getTimes(), randomGenerator);
        race.performRace();

        RaceResult raceResult = new RaceResult(race);
        return new RaceResultDTO(raceResult.getRaceWinnerList());
    }


    private List<Car> convertNamesToCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        names.forEach(name -> {
            Member member = new Member(name);
            cars.add(Car.of(member));
        });
        return cars;
    }


}
