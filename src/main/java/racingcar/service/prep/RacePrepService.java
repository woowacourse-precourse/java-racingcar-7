package racingcar.service.prep;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.Registration;

public class RacePrepService {

    private final PaddockService paddockService;

    public RacePrepService() {
        this.paddockService = new PaddockService();
    }

    private List<Car> prepareCars(Registration raceInfo) {
        return paddockService.createPaddock(raceInfo).getEntry();
    }

    public Race prepare(Registration raceInfo) {
        return new Race(raceInfo.getLapCount(),prepareCars(raceInfo));
    }
}
