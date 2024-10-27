package racingcar.application.service.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.service.history.RacingHistoryService;
import racingcar.domain.car.RacingCar;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.util.NameParser;

import java.util.List;

public class RacingCarService {

    private final NameParser nameParser;
    private final InMemoryRacingCarRepository racingRepository;
    private final RacingHistoryService racingHistoryService;
    private int tryNumber;

    public RacingCarService() {
        this.nameParser = new NameParser();
        this.racingRepository = InMemoryRacingCarRepository.getInstance();
        this.racingHistoryService = new RacingHistoryService();
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

    // TODO : 시도횟수 입력받기
    public void inputTryNumber(int tryNumber){
        this.tryNumber = tryNumber;
    }

    // TODO : 시도횟수 만큼 랜덤 숫자 뽑기
    public void startGame(){
        for (int i = 0; i < tryNumber ; i++) {
            for (RacingCar racingCar : racingRepository.getRacingCars()) {
                int number = Randoms.pickNumberInRange(0, 9);
                moveRacingCar(racingCar, number);
                saveRacingHistory(racingCar);
            }
        }
    }

    // TODO : 4 이상인 경우 전진하기
    public void moveRacingCar(RacingCar racingCar, int number){
        if(number > 4){
            racingCar.move();
            racingRepository.saveRacingCar(racingCar);
        }
    }

    private void saveRacingHistory(RacingCar racingCar){
        racingHistoryService.saveHistory(racingCar);
    }
}
