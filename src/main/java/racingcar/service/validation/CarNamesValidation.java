package racingcar.service.validation;

public class CarNamesValidation {

    public static void validateEmpty(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름들이 입력되지 않았습니다");
        }
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름들이 입력되지 않았습니다");
        }
    }

    public static void validateBetweenDelimiter(String input) {
        String[] cars = input.split(",",-1); // -1을 limit으로 넣어주어 문자열의 마지막이 구분자인 경우도 검출
        for (String car: cars){
            throwIfEmpty(car.trim().isEmpty());
        }
    }

    private static void throwIfEmpty(boolean state){
        if (state){
            throw new IllegalArgumentException("[ERROR] 구분자(,) 사이에는 자동차 이름이있어야 합니다");
        }
    }

    public static void validateDelimiter(String input) {
        // 쉼표(,)로 나누었을 때, 쉼표 이외의 문자가 포함되어 있으면 예외 처리
        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException("[ERROR] 구분자는 쉼표(,)만 사용 가능합니다");
        }
    }

    public static void validateOver(String carName) {
        if (carName.length()>5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자가 넘어가선 안됩니다");
        }
    }

    public static void validateEng(String carName) {
        if (!carName.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다");
        }
    }
}
