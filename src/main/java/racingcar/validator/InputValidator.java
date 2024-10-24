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
}
