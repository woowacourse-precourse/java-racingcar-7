package racingcar.application.service.winner;

import java.util.List;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.repository.RacingCarRepository;
import racingcar.domain.history.repository.RacingHistoryRepository;
import racingcar.domain.winner.Winner;
import racingcar.domain.winner.repository.WinnerRepository;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.persistence.InMemoryRacingHistoryRepository;
import racingcar.infrastructure.persistence.InMemoryWinnerRepository;

public class WinnerService {

    private final RacingHistoryRepository racingHistoryRepository;
    private final RacingCarRepository racingCarRepository;
    private final WinnerRepository winnerRepository;

    public WinnerService() {
        this.racingHistoryRepository = InMemoryRacingHistoryRepository.getInstance();
        this.racingCarRepository = InMemoryRacingCarRepository.getInstance();
        this.winnerRepository = InMemoryWinnerRepository.getInstance();
    }

    public void saveWinners(){
        for(RacingCar racingCar : racingCarRepository.getRacingCars()){
            if(selectWinners(racingCar)){
                winnerRepository.saveWinner(new Winner(racingCar.getName()));
            }
        }
    }

    public boolean selectWinners(RacingCar racingCar){
        int maxDistance = racingHistoryRepository.getMaxDistance();
        return maxDistance == racingCar.getDistance();
    }

    public List<Winner> getWinners(){
        return winnerRepository.getWinners();
    }
}
