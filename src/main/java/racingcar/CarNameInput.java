package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInput {

    private static final String DELIMITER = ",";

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        validateDelimiter(input);

        String[] carNamesArray = input.split(DELIMITER, -1);
        List<String> carNames = parseCarNames(carNamesArray);

        validateParticipants(carNames);

        return carNames;
    }

    private void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 하며, 쉼표(,)로 구분해야 합니다.");
        }
    }

    private List<String> parseCarNames(String[] carNamesArray) {
        List<String> carNames = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        for (String carName : carNamesArray) {
            String trimmedName = carName.trim();
            validateCarName(trimmedName, uniqueNames);
            carNames.add(trimmedName);
        }
        return carNames;
    }

    private void validateCarName(String carName, Set<String> uniqueNames) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        if (!uniqueNames.add(carName)) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }

    private void validateParticipants(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }
}
