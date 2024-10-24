package racingcar;

public class Application {
    static String[] cars;
    static int[] carsPosition;
    public static void main(String[] args) {

    }

    public static String[] carNameSplitter(String input) {
        String[] result = input.split(",");
        for (String s : result) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 한다.");
            }
        }
        return result;
    }
}
