package racingcar.valid;

public class RaceValidator {
    public static void validateCarName(String[] names) {
        for (String name : names){
            if (name == null || name.isEmpty() || name.length() > 5)
                throw new IllegalArgumentException();
        }
    }

    public static void validateRaceCount(String count){
        if (count == null || count.isEmpty() || !isNumeric(count) || Integer.parseInt(count) < 1){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(String value){
        return value.matches("\\d+");
    }
}
