package racingcar.runner;

import racingcar.domain.RacingCar;

public class Output {

    public static final String DELIMITERS_OF_CAR_ID = ", ";

    private final StringBuilder out;

    public Output() {
        this.out = new StringBuilder();
    }

    public void newLine() {
        out.append('\n');
    }

    public void writeln(RacingCar car) {
        out.append(car);
        newLine();
    }

    public void write(String str) {
        out.append(str);
    }

    public void writeWinner(RacingCar car) {
        out.append(car.getId());
        out.append(DELIMITERS_OF_CAR_ID);
    }

    public void printWinner() {
        deleteLastDelimiters();
        println();
    }

    protected void deleteLastDelimiters() {
        int lastDelimiterIdx = out.lastIndexOf(DELIMITERS_OF_CAR_ID);
        if (lastDelimiterIdx != -1) {
            out.delete(lastDelimiterIdx, out.length());
        }
    }

    private void println() {
        System.out.println(out);
    }

    protected String get() {
        return out.toString();
    }
}
