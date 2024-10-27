package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.InputView;

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
    private final InputView inputView = InputView.getInstance();

    private RaceController() {
    }

    public static RaceController getInstance() {
        return instance;
    }
    //------------------------//


    public void displayRaceLapInputPage() {
        String lap = inputView.getLapCount();
        raceService.isLapValid(lap);
        raceService.save(raceService.createRace(lap));
    }

    public void raceStartById(int id) {
        StringBuilder output = new StringBuilder();
        Race race = raceService.findById(id);
        raceService.displayCarMovementByLap(race, output);
        System.out.println(raceService.displayWinner(race, output));
    }
}
