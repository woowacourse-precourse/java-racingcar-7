package racingcar.car;

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
}
