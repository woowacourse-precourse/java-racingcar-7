package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_CAR = 2;

    public List<String> askCarNames() {
        System.out.println(QUESTION_CAR_NAMES);
        String inputCarNames = Console.readLine();
        List<String> carNames = convertInputCarNamesToList(inputCarNames);

        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        if (carNames.size() < MIN_CAR) {
            throw new IllegalArgumentException("경주를 하기 위해서는 최소 2대 이상의 자동차가 필요합니다.");
        }

        return convertInputCarNamesToList(inputCarNames);
        }

    public int askTryCount () {
        System.out.println(QUESTION_TRY_COUNT);
        return Integer.parseInt(Console.readLine());
    }

    private List<String> convertInputCarNamesToList(String inputCarNames) {
        String[] CarNames = inputCarNames.split(",");
        List<String> carNames = new ArrayList<>();

        for (String CarName : CarNames) {
            String trimmedCarName = CarName.trim();
            carNames.add(trimmedCarName);
        }
        return carNames;
    }

}
