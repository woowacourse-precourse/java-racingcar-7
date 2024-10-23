package racingcar;

public class Validator {

    public int validateInput(String cycleInput) {
        int cycle;
        if (cycleInput.isEmpty())
            throw new IllegalArgumentException();

        try {
            cycle = Integer.parseInt(cycleInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (cycle <= 0)
            throw new IllegalArgumentException();
        return cycle;
    }
}
