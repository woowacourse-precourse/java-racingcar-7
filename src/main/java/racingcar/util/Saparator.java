package racingcar.util;

public class Saparator {
    private String delimiter;

    public Saparator(String delimiter){
        this.delimiter = delimiter;
    }

    public String[] split(String input){
        return input.split(delimiter);
    }
}
