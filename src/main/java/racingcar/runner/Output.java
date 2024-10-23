package racingcar.runner;

import racingcar.domain.RacingCar;

public class Output {

    public static final String DELIMITERS_OF_CAR_ID = ", ";

    private final StringBuilder out;

    public Output() {
        this.out = new StringBuilder("");
    }

    public void newLine() {
        out.append('\n');
    }

    public void add(RacingCar car) {
        out.append(car);
        newLine();
    }

    public void add(String str) {
        out.append(str);
    }

    public void addWinner(RacingCar car) {
        out.append(car.getId());
        out.append(DELIMITERS_OF_CAR_ID);
    }

    protected void deleteLastDelimiters() {
        out.delete(out.lastIndexOf(DELIMITERS_OF_CAR_ID), out.length());
    }

    protected String get() {
        return out.toString();
    }

    public void print() {
        deleteLastDelimiters();
        System.out.println(out);
    }
}
