package racingcar.application.service.car;

import racingcar.domain.car.RacingCar;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.util.NameParser;

import java.util.List;

public class RacingCarService {

    private final NameParser nameParser;
    private final InMemoryRacingCarRepository racingRepository;

    public RacingCarService(NameParser nameParser) {
        this.nameParser = nameParser;
        this.racingRepository = InMemoryRacingCarRepository.getInstance();
    }

    // TODO : 이름 입력받기
    public void inputCarName(String racingCars) {
        List<String> names = nameParser.parsingName(racingCars);

        for (String name : names) {
            saveName(initRacingCar(name));
        }
    }

    // TODO : 레이싱 카 초기화
    private RacingCar initRacingCar(String name) {
        return new RacingCar(name);
    }

    // TODO : 이름 저장하기
    private void saveName(RacingCar racingCar) {
        racingRepository.saveRacingCar(racingCar);
    }

    // TODO : 시도횟수 입력받기

    // TODO : 시도횟수 만큼 랜덤 숫자 뽑기

    // TODO : 4 이상인 경우 전진하기
}
