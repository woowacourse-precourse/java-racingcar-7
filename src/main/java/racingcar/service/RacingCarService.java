package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.combiner.Combiner;
import racingcar.constant.GamePolicy;
import racingcar.constant.Message;
import racingcar.model.RacingCarModel;
import racingcar.parser.InputParser;
import racingcar.validation.InputValidator;

public class RacingCarService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final Combiner combiner;
    private final RacingCarModel racingCarModel;

    public RacingCarService() {
        this.inputValidator = new InputValidator();
        this.inputParser = new InputParser();
        this.combiner = new Combiner();
        this.racingCarModel = new RacingCarModel();
    }

    public void settingRacingCars(String carNameInput) {
        inputValidator.validateInputIsEmpty(carNameInput);

        String[] carNames = inputParser.splitInput(carNameInput);
        for (String carName : carNames) {
            racingCarModel.add(carName);
        }
    }

    public String racingStart(String tryCountInput) {
        inputValidator.validateInputIsEmpty(tryCountInput);
        inputValidator.validateTryCount(tryCountInput);

        StringBuilder sb = new StringBuilder();

        int tryCount = inputParser.parseInt(tryCountInput);
        for (int i = 0; i < tryCount; i++) {
            round(sb);
        }

        return sb.toString();
    }

    private void round(StringBuilder sb) {
        int carCount = racingCarModel.size();

        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(GamePolicy.RANDOM_MINIMUM, GamePolicy.RANDOM_MAXIMUM));
        }
        racingCarModel.forwardAction(randomNumbers);
        racingCarModel.appendRunResult(sb);
        sb.append(Message.NEW_LINE);
    }

    public String racingResult() {
        List<String> winners = racingCarModel.getWinner();
        return combiner.combineResult(winners);
    }
}