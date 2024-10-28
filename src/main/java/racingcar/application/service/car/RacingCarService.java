package racingcar.application.service.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.service.history.RacingHistoryService;
import racingcar.application.service.winner.WinnerService;
import racingcar.domain.car.RacingCar;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.util.NameParser;
import racingcar.infrastructure.util.NameValidator;

import java.util.List;

public class RacingCarService {

    private final NameParser nameParser;
    private final InMemoryRacingCarRepository racingRepository;
    private final RacingHistoryService racingHistoryService;
    private final WinnerService winnerService;
    private int tryNumber;

    public RacingCarService() {
        this.nameParser = new NameParser();
        this.racingRepository = InMemoryRacingCarRepository.getInstance();
        this.racingHistoryService = new RacingHistoryService();
        this.winnerService = new WinnerService();
    }

    public void inputCarName(String racingCars) {
        List<String> names = nameParser.parsingName(racingCars);

        for (String name : names) {
            saveName(initRacingCar(name));
        }
    }

    private RacingCar initRacingCar(String name) {
        return new RacingCar(name);
    }

    private void saveName(RacingCar racingCar) {
        racingRepository.saveRacingCar(racingCar);
    }

    public void inputTryNumber(String tryNumber) {
        this.tryNumber = NameValidator.validNumber(tryNumber);
    }

    public void startGame(){
        for (int i = 0; i < tryNumber ; i++) {
            for (RacingCar racingCar : racingRepository.getRacingCars()) {
                int number = Randoms.pickNumberInRange(0, 9);
                moveRacingCar(racingCar, number);
                saveRacingHistory(racingCar);
            }
        }

        saveWinners();
    }

    public void moveRacingCar(RacingCar racingCar, int number){
        if(number > 4){
            racingCar.move();
            racingRepository.saveRacingCar(racingCar);
        }
    }

    private void saveRacingHistory(RacingCar racingCar){
        racingHistoryService.saveHistory(racingCar);
    }

    private void saveWinners(){
        winnerService.saveWinners();
    }
}
