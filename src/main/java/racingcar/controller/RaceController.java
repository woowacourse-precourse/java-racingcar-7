package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.service.RaceService;

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

    public void saveAll(CarsSaveRequestDto requestDto) {
        raceService.isCarNameValid(requestDto);
        raceService.saveAll(requestDto);
    }

    public Race raceStart(int lap) {
        raceService.isLapValid(lap);
        Race race = raceService.createRace(lap);
        raceService.getCarMovementByLap(race);

        return race;
    }

    public void displayWinner(Race race) {
        raceService.getWinner(race);
    }
}
