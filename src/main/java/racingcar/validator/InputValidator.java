package racingcar.validator;

public class InputValidator {

    public boolean hasNoInput(String input) {
        //문자열이 비어있으면 true, 아니면 false
        return input.isEmpty();
    }

    //문자열 길이가 5이하면 true, 5보다 크면 false
    public boolean checkInputLength(String input) {
        String[] splitInput = input.split(",");
        for (String name : splitInput) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    //숫자가 있으면 true, 없으면 false
    public boolean includeNumber(String input) {
        String[] splitInput = input.split(",");
        for (String name : splitInput) {
            if (checkHasNumber(name)) {
                return true;
            }
        }
        return false;
    }

    //이름에 숫자가 있는지 확인
    private static boolean checkHasNumber(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }


}
