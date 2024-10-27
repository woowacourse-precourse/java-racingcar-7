package racingcar.validation;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private final static String regex = "^[a-zA-Z0-9가-힣]+$";

    private static List<String> getUniqueName(String userInput){
        List<String> splitedInput = Arrays.asList(userInput.split(","));

        Set<String> uniqueSet = new LinkedHashSet<>(splitedInput);
        return uniqueSet.stream().toList();
    }

    public static List<String> validateCarNameAndReturn(String userInput){
        List<String> splitedInput = getUniqueName(userInput);

        if (splitedInput.size() <= 1){
            throw new IllegalArgumentException("생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다.");
        }

        for (String name: splitedInput){
            if (!name.matches(regex)){
                throw new IllegalArgumentException("이름은 숫자, 알파벳, 한글 조합만 가능합니다.");
            }

            if (name.isEmpty() || name.length() > 5){
                throw new IllegalArgumentException("이름은 1글자 이상, 5글자 이하 입니다.");
            }
        }
        return splitedInput;
    }

    public static int validateGameCountAndReturn(String userInput){
        long longInput;

        try {
            longInput = Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (longInput <= 0 || longInput > 99999){
            throw new IllegalArgumentException("시도할 횟수는 1이상 99999이하의 숫자입니다.");
        }
        return (int) longInput;
    }
}
