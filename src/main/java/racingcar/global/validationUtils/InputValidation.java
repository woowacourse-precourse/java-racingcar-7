package racingcar.global.validationUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    private static final String REGEX = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
    private static final Integer LIMITS = 5;

    public static void checkDuplicate(String carName) {
        Set<String> duplicateCheck = new HashSet<>();
        if (!duplicateCheck.add(carName)) {
            throw new IllegalArgumentException("카 이름이 중복 되었습니다 " + carName);
        }
    }

    public static void checkSpecialCharacters(String carName) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(carName);
        if (matcher.find()) {
            throw new IllegalArgumentException("한글 또는 영어만 허용합니다: " + carName);
        }
    }


    public static void checkLength(String carName) {
        if (carName.length() > LIMITS) { // 길이가 5 초과인 경우
            System.out.println("차 이름 글자 수 5 이상 : " + carName.length());
            throw new IllegalArgumentException("자동차 이름이 5자가 넘습니다 : " + carName + " , " + carName.length());
        }
    }

    public static void checkOnce(String[] car){
        if (car.length == 1) {
           throw new IllegalArgumentException("자동차 경주 하려면 두대 이상 되어야 합니다");
        }
    }


    public static void  checkParseInt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용 하지 않습니다 : " + number);
        }
    }
}
