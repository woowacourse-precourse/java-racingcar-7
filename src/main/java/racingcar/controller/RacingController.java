package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.service.ResultService;
import racingcar.service.SetUpService;
import racingcar.view.RacingView;

public class RacingController {
    private final SetUpService setUpService;
    private final RacingService racingService;
    private final ResultService resultService;
    private final RacingView racingView;

    private RacingController() {
        setUpService = SetUpService.getInstance();
        racingService = RacingService.getInstance();
        resultService = ResultService.getInstance();
        racingView = RacingView.getInstance();
    }

    private static class SingletonHelper {
        private static final RacingController INSTANCE = new RacingController();
    }

    public static RacingController getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void run() {
        racingView.showDescription();
        String carNames = racingView.inputCarNames();
        String rawRaceCount = racingView.inputRaceCount();

        int raceCount = checkRaceCount(rawRaceCount);
        setUpService.setUpRace(carNames);

        for (int count = 1; count <= raceCount; count++) {
            race(count);
        }

        String result = resultService.getResult();
        racingView.outputResult(result);
    }

    private int checkRaceCount(String rawRaceCount) {
        try {
            int raceCount = Integer.parseInt(rawRaceCount);

            if (raceCount > 20 || raceCount <= 0) {
                throw new IllegalArgumentException();
            }

            return raceCount;
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 1부터 20까지의 정수로 입력해주세요.");
        }
    }

    private void race(int count) {
        racingService.race();

        String raceProgress = racingService.getRaceProgress();
        racingView.outputProgress(count, raceProgress);
    }
}
