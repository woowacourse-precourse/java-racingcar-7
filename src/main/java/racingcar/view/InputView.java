package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_CAR_SIZE = 2;

    private final Supplier<String> inputProvider;

    public InputView() {
        this(Console::readLine);
    }

    // 테스트 할 때 사용함
    public InputView(Supplier<String> inputProvider) {
        this.inputProvider = inputProvider;
    }

    public List<String> askCarNames() {
        System.out.println(QUESTION_CAR_NAMES);
        String inputCarNames = inputProvider.get();
        List<String> carNames = convertInputCarNamesToList(inputCarNames);

        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        if (carNames.size() < MIN_CAR_SIZE) {
            throw new IllegalArgumentException("경주를 하기 위해서는 최소 2대 이상의 자동차가 필요합니다.");
        }

        return carNames;
    }

    public int askTryCount() {
        System.out.println(QUESTION_TRY_COUNT);
        String input = inputProvider.get();
        int tryCount;

        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        if (tryCount <= 0) {
            throw new IllegalArgumentException("양의 정수를 입력해야 합니다.");
        }

        return tryCount;
    }


    private List<String> convertInputCarNamesToList(String inputCarNames) {
        String[] carNamesArray = inputCarNames.split(",");
        List<String> carNames = new ArrayList<>();

        for (String carName : carNamesArray) {
            String trimmedCarName = carName.trim();
            carNames.add(trimmedCarName);
        }
        return carNames;
    }
}
