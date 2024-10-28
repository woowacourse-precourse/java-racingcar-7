package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.DependencyConfig;
import racingcar.controller.RacingController;
import racingcar.model.dto.RacingRequestDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        DependencyConfig dependencyConfig = new DependencyConfig();
        RacingController racingController = dependencyConfig.racingController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.show(
                racingController.start(RacingRequestDTO.create(inputView.inputNames(), inputView.inputRoundCount())));
        Console.close();
    }
}
