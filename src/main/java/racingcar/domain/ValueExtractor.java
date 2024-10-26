package racingcar.domain;

public class ValueExtractor{

    public static String[] getDelimitedValue(String input){

        return input.split(",", -1);
    }
}
