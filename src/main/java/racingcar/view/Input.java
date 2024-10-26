package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashMap;
import org.assertj.core.internal.IterableElementComparisonStrategy;

public class Input {

    public HashMap<String, Integer> getCarNames() {
        String[] carNameList = checkCarNamesError(readLine());
        HashMap<String, Integer> carNames = new HashMap<>();
        Arrays.stream(carNameList).forEach(s -> carNames.put(s, 0));
        return carNames;
    }

    public String[] checkCarNamesError(String readLine) {
        String inputCarNames = readLine;
        if (inputCarNames == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
        String[] carNameList = inputCarNames.split(",");
        Arrays.stream(carNameList).forEach(name -> {
            name = name.trim();
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름을 공백으로 할 수 없습니다.");
            }
        });
        return Arrays.stream(carNameList).map(String::trim).toArray(String[]::new);
    }

    public int getAttemptedNumber() {
        return Integer.parseInt(readLine());
    }

}
