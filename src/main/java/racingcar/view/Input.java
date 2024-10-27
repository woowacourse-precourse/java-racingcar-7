package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashMap;

public class Input {

    public HashMap<String, Integer> getCarNames() {
        String[] carNameList = checkCarNamesError(readLine());
        HashMap<String, Integer> carNames = new HashMap<>();
        Arrays.stream(carNameList).forEach(s -> carNames.put(s, 0));
        return carNames;
    }

    public String[] checkCarNamesError(String readLine) {
        if (readLine == null) {
            throw new IllegalArgumentException("입력값이 null 입니다.");
        }
        String[] carNameList = readLine.split(",");
        if (Arrays.stream(carNameList).allMatch(String::isBlank)) {
            throw new IllegalArgumentException("올바른 이름이 입력되지 않았습니다.");
        }
        Arrays.stream(carNameList).forEach(name -> {
            name = name.trim();
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자를 넘었습니다.");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름을 공백으로 할 수 없습니다.");
            }
        });
        if (Arrays.stream(carNameList).distinct().count() != carNameList.length) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
        return Arrays.stream(carNameList).map(String::trim).toArray(String[]::new);
    }

    public int getAttemptedNumber() {
        return checkAttemptedNumberError(readLine());
    }

    public int checkAttemptedNumberError(String readLine) {
        try {
            int attemptedNumber = Integer.parseInt(readLine);
            if (attemptedNumber < 0) {
                throw new IllegalArgumentException("음수를 입력하였습니다.");
            }
            return attemptedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못 입력되었습니다.");
        }
    }
}
