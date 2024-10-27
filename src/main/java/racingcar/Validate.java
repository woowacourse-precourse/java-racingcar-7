package racingcar;

public class Validate {

    public static void isNameLengthValid(String racingName){
        String[] numbers = racingName.split(","); // 콤마(,), 콜론(:)을 구분자로 지정

        for(String num : numbers) {
            if (num.length() > 5) { // 이름이 5글자 이상일 때
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static void isNameCommaSeparated(String name) {

        if(!name.matches("[a-zA-Z0-9,]+")) { // 영어, 숫자 그리고 쉼표(,)가 아닐 때
            throw new IllegalArgumentException("레이싱 카 이름은 영어, 숫자만 들어갈 수 있습니다.");
        }
    }
    public static void isNumeric(String try_num) {

        if(!try_num.matches("\\d+")) { // 숫자가 아닐 때
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
