package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingController {
    private final RacingModel racingModel;
    private final InputView inputView;
    private final OutputView outputView;


    public RacingController(RacingModel racingModel, InputView inputView, OutputView outputView) {
        this.racingModel = racingModel;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void validateCharacters(List<String> names) {
        final String englishRegex = "a-zA-Z";
        final String koreanRegex = "ㄱ-ㅎㅏ-ㅣ가-힣";

        if (!names.stream().allMatch(name -> name.matches("^[" + englishRegex + koreanRegex + "]*$"))) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 들어가 있습니다 (한국어+영어만 가능).");
        }
    }

    public static void validateLength(List<String> names) {
        final int MAX_NAME_LENGTH = 5;

        if (names.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("각 이름의 길이는 " + MAX_NAME_LENGTH + "자를 넘길 수 없습니다.");
        }

        if (names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("빈 이름이 존재합니다.");
        }
    }

    public void run() {

        List<String> names = inputView.getCarNames();

        validateCharacters(names);
        validateLength(names);

        int totalRounds = inputView.getTotalRounds();

        LinkedHashMap<String,Integer> cars = new LinkedHashMap<>();

        for (String name: names) {
            cars.put(name, 0);
        }

        outputView.printStart();
        for (int round = 0; round < totalRounds; round++) {
            cars = racingModel.moveCars(cars);
            outputView.printRound(cars);
        }

        outputView.printWinners(cars);
    }

}
