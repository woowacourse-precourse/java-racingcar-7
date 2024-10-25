package racingcar.model.carname;

public class CarNameSplit {
    private static final String DELIMITER = ",";

    public static String[] nameSplit(String str) {
        return str.split(DELIMITER);
    }

}
