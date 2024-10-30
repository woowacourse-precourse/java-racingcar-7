package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RaceProcess;

public class RacingService {
    private final RaceProcess raceProcess;

    public RacingService(RaceProcess raceProcess) {
        this.raceProcess = raceProcess;
    }

    public RaceProcess playRound() {
        raceProcess.moveCars();
        return raceProcess;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return raceProcess.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return raceProcess.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
