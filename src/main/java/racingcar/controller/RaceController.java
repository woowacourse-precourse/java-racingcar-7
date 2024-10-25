package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.service.RaceService;
import racingcar.validation.CarNameValidator;

/**
 * packageName    : racingcar.controller
 * fileName       : RaceController
 * author         : ehgur
 * date           : 2024-10-25
 * description    : 레이스 관련 api 호출하는 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25         ehgur            최초 생성
 */

public class RaceController {

    //----- 싱글톤 패턴 적용 -----//
    private static final RaceController instance = new RaceController();
    private final RaceService raceService = RaceService.getInstance();
    private RaceController() {}
    public static RaceController getInstance() {
        return instance;
    }
    //------------------------//

    public void saveAll(Cars cars) {
        raceService.saveAll(cars);
    }

    public void isCarNameValid(CarsSaveRequestDto requestDto) {
        raceService.isCarNameValid(requestDto);
    }

}
