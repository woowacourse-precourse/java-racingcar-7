package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.domain.repository.RaceRepository;
import racingcar.validation.CarNameValidator;

/**
 * packageName    : racingcar.service
 * fileName       : RaceService
 * author         : ehgur
 * date           : 2024-10-25
 * description    : 레이스 관련 로직을 구현한 서비스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25         ehgur            최초 생성
 */

public class RaceService {
    //----- 싱글톤 패턴 적용 -----//
    private static final RaceService instance = new RaceService();
    private final RaceRepository raceRepository = RaceRepository.getInstance();
    private RaceService(){}
    public static RaceService getInstance() {
        return instance;
    }
    //------------------------//

    public void saveAll(Cars cars) {
        raceRepository.saveAll(cars);
    }

    public void isCarNameValid(CarsSaveRequestDto requestDto) {
        CarNameValidator.run(requestDto);
    }

}
