package racingcar.service;

public class InputValidator {
    public boolean validator(String[] input) {
        for (String item : input) {
            if(item.length() > 5 || item.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
