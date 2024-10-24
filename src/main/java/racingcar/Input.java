package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

/**
 * input string을 처리하는 클래스
 */
class Input {
    String string = Console.readLine();

    /**
     * 입력값을 ,로 split하여 ArrayList에 담음
     * @param input 입력 문자열
     * @return split한 ArrayList: 차 이름으로 사용
     * @throws Validate.DuplicateNameDetected 이름에 중복값이 있으면 예외 발생
     * @throws Validate.InvalidNameLength 공백 또는 길이가 5를 초과하면 예외 발생
     */
    static ArrayList<String> splitInput(String input) throws Validate.DuplicateNameDetected, Validate.InvalidNameLength {
        String[] nameContainer = input.split(",");
        ArrayList<String> names = new ArrayList<>();

        for (String name : nameContainer) {
            String trimedName = name.trim();
            Validate.checkName(trimedName);
            if (names.contains(trimedName)) {
                throw new Validate.DuplicateNameDetected();
            }
            names.add(trimedName);
        }
        return names;
    }

    /**
     * 입력값을 int로 변환
     * @param input 입력값(문자열)
     * @return int로 변환된 값: 실행 횟수
     * @throws Validate.CannotBeNegative 음수이면 예외 발생
     */
    static int getNumber(String input) throws Validate.CannotBeNegative {
        int number = Integer.parseInt(input);
        if (!Validate.validNumber(number)) {
            throw new Validate.CannotBeNegative();
        }
        return number;
    }
}
