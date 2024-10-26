package racingcar.application.service;

import java.util.List;
import racingcar.application.in.RacingCarUseCase;
import racingcar.config.context.annotation.Service;
import racingcar.domain.Car;
import racingcar.domain.Racing;

@Service
public class RacingCarService implements RacingCarUseCase {

    public RacingCarService() {
    }

    @Override
    public Racing startRacing(List<Car> cars, int tryCount) {
        Racing racing = createRacing(cars);
        
        for (int index = 0; index < tryCount; index++) {
            racing.start();
        }

        return racing;
    }

    private Racing createRacing(List<Car> cars) {
        return Racing.of(cars);
    }
}
