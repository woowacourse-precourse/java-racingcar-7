package racingcar.service;

import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingRecording;
import racingcar.model.dto.RacingWinners;
import racingcar.model.entity.Car;
import racingcar.model.entity.CarsByNames;
import racingcar.model.entity.RacingTurn;
import racingcar.model.entity.RacingTurns;
import racingcar.repository.Repository;

import java.util.Map;
import java.util.function.Supplier;

/**
 * 자동차들 객체를 RacingController로부터 전달 받아서 경주 기능을 수행
 * RacingController로부터 결과값을 요청받으면 저장소에 요청하고 값을
 * 회신하는 역할 수행하는 RacingService 인터페이스를 구현한 클래스
 */
public class RacingServiceImpl implements RacingService {

    private final Repository repository;

    public RacingServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void raceOfCarsAndTurns(CarsByNames carsByNames, RacingTurns turns) {
        repository.saveStartMessage();

        raceAndRecordOfCarsAndTurns(carsByNames, turns);

        RacingWinners racingWinners = RacingWinners.getFromCars(carsByNames);
        repository.saveResult(racingWinners);
    }

    private void raceAndRecordOfCarsAndTurns(CarsByNames carsByNames, RacingTurns turns) {
        for (RacingTurn turn : turns) {
            for (Map.Entry<String, Supplier<Integer>> entry : turn.getEntrySet()) {
                String name = entry.getKey();
                Supplier<Integer> strategy = entry.getValue();
                Car car = carsByNames.get(name);
                car.moveBy(strategy);
                repository.saveProgress(new RacingProgress(car));
            }
            repository.saveBreakingLine();
        }
    }

    @Override
    public RacingRecording getRecord() {
        return repository.getRecord();
    }

}
