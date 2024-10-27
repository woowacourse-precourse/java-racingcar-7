package racingcar.controller;

import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.service.create.RacingCarFactory;
import racingcar.trynumber.service.TryNumberCreateService;
import racingcar.racingcar.service.racing.RacingService;
import racingcar.racingcar.service.create.RacingCarCreateService;
import racingcar.trynumber.domain.TryNumber;
import racingcar.trynumber.service.TryNumberFactory;
import racingcar.view.output.service.CommonOutputService;

public class RacingController {
    private final RacingCarCreateService racingCarCreateProcess;
    private final TryNumberCreateService tryNumberCreateProcess;
    private final RacingService racingProcess;
    private final CommonOutputService commonOutputViewProcess;
    public RacingController(
            RacingCarCreateService racingCarCreateProcess,
            TryNumberCreateService tryNumberCreateProcess,
            RacingService racingProcess,
            CommonOutputService commonOutputViewProcess) {
        this.racingCarCreateProcess = racingCarCreateProcess;
        this.tryNumberCreateProcess = tryNumberCreateProcess;
        this.racingProcess = racingProcess;
        this.commonOutputViewProcess = commonOutputViewProcess;
    }
    public void run() {
        RacingCarInfo racingCarInfo = createRacingCarInfo();
        TryNumber tryNumber = createTryNumber();
        racingProcess.racing(racingCarInfo, tryNumber);
    }
    private RacingCarInfo createRacingCarInfo() {
        RacingCarInfo racingCarInfo = racingCarCreateProcess.create(RacingCarFactory::create);
        commonOutputViewProcess.carOutputView(racingCarInfo);
        return racingCarInfo;
    }
    private TryNumber createTryNumber() {
        TryNumber tryNumber = tryNumberCreateProcess.create(TryNumberFactory::create);
        commonOutputViewProcess.tryNumberOutputView(tryNumber);
        return tryNumber;
    }

}
