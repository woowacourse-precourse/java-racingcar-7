package racingcar.car;

import java.util.List;

public class CarView {
    public static String executionResult(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s : ", car.getName()));
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String winnerNames(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < names.size() - 1; i++) {
            sb.append(names.get(i));
            sb.append(", ");
        }
        sb.append(names.getLast());
        return sb.toString();
    }
}
