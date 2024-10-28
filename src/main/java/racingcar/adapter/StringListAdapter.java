package racingcar.adapter;

public class StringListAdapter {

    public String[] parseCars(String input) {
        try{
            String[] cars = input.split(",");
            validateCarNames(cars);
            return cars;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    private void validateCarNames(String[] strings) throws IllegalArgumentException {
        for (String string : strings) {
            if (string.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int parseCount(String input) {
        try{
            int count = Integer.parseInt(input);
            isValidSize(count);
            return count;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    private void isValidSize(int count) throws IllegalArgumentException {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}
