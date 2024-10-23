package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private final static int MAX_LENGTH = 5;
    private final static String DELIM = ",";
    final static List<String> userNames = new ArrayList<>();

    public InputDTO getInput() {
        String carNames = Console.readLine();
        String tryNums = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames);
        if (!tryNums.isBlank()) {
            throw new IllegalArgumentException("숫자 공백 입력 값은 허용하지 않습니다.");
        }
        if (!isNumeric(tryNums)) {
            throw new IllegalArgumentException("숫자가 아닌 값은 올 수 없습니다.");
        }
        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken(DELIM);
            if (!isMoreThanFive(name)) {
                throw new IllegalArgumentException("이름이 5자 이상일 수 없습니다.");
            }
            if (isDuplicate(carNames)) {
                throw new IllegalArgumentException("이름이 중복되선 안 됩니다.");
            }
            userNames.add(name);
        }
        return new InputDTO(userNames, Long.parseLong(tryNums));
    }

    //todo: validateInput 클래스 생성해 유효성 검사 클래스 분리
    public boolean isContainComma(String input) {
        if (!input.contains(DELIM)) {
            return false;
        }
        return true;
    }

    public boolean isBlank(String input) {
        if (!input.isBlank()) {
            return false;
        }
        return true;
    }

    public boolean isDuplicate(String carName) {
        return userNames.contains(carName);
    }

    public boolean isMoreThanFive(String carName) {
        if (carName.length() > MAX_LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isNumeric(String tryNums) {
        for (char num : tryNums.toCharArray()) {
            if (!Character.isDigit(num)) {
                return false;
            }
        }
        return true;
    }


}
