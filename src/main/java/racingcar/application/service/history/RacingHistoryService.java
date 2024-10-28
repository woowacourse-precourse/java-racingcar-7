package racingcar.application.service.history;

import racingcar.domain.car.RacingCar;
import racingcar.domain.history.RacingHistory;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.persistence.InMemoryRacingHistoryRepository;

import java.util.List;

public class RacingHistoryService {
    private final InMemoryRacingHistoryRepository historyRepository;

    public RacingHistoryService() {
        this.historyRepository = InMemoryRacingHistoryRepository.getInstance();
    }

    public void saveHistory(RacingCar racingCar) {
        historyRepository.saveRacingHistory(new RacingHistory(racingCar.getName(), racingCar.getDistance()));
    }

    public void printRacingResult(){
        List<RacingHistory> racingHistories =  historyRepository.getRacingHistory();
        int numberOfCars = InMemoryRacingCarRepository.getInstance().getSize();

        for(int i = 0; i < racingHistories.size(); i++) {
            RacingHistory racingHistory = racingHistories.get(i);
            System.out.print(racingHistory.getRacingCarName() + " : ");
            System.out.println(racingHistory.getPrintDistance());

            if((i + 1) % numberOfCars == 0) {
                System.out.println();
            }
        }
    }
}
