package racingcar.model;


public class CarNameDelimiter {

    private final static String DELIMITER = ",";
    private String[] carNames;


    public String[] NameDelimiter(String name) {

        carNames = name.trim().split("\\s*" + DELIMITER + "\\s*");

        return carNames;
    }


}
