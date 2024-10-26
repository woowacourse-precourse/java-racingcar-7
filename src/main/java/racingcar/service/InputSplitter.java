package racingcar.service;

public class InputSplitter {
    private static final String DELIMETER = ",";

    public String[] getCarNmaes(String input) {
        return input.split(DELIMETER);
    }
}
