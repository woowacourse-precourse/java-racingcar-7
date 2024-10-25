package racingcar.service;

import racingcar.model.entity.Car;
import racingcar.model.entity.Cars;
import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingResult;
import racingcar.model.entity.RacingChance;
import racingcar.model.dto.RacingWinners;
import racingcar.repository.Repository;

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
    public void raceOfCarsAndChance(Cars cars, RacingChance racingChance) {
        repository.saveStartMessage();
        raceAndSaveProgress(cars, racingChance);

        RacingWinners racingWinners = RacingWinners.getFromCars(cars);
        repository.saveResult(racingWinners);
    }

    @Override
    public RacingResult getResult() {
        return repository.getResult();
    }

    private void raceAndSaveProgress(Cars cars, RacingChance racingChance) {
        for (int i = 0; i < racingChance.getValue(); i++) {
            for (Car car : cars) {
                car.move();
                RacingProgress progress = new RacingProgress(car);
                repository.saveProgress(progress);
            }
            repository.saveBreakingLine();
        }
    }

}
