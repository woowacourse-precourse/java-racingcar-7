package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.accelerator.BrokenAccelerator;

public class CarRacing {

    private int attempts;
    private final List<Car> carList = new ArrayList<>();

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public static String[] parseCarList(String carNames) {
        return carNames.split(",");
    }

    public void parseAttempts(String input) {
        try {
            attempts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (attempts < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String winner(List<Car> carList) {
        carList.sort(((o1, o2) -> o2.getMileage() - o1.getMileage()));
        int maxMileage = carList.getFirst().getMileage();
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getMileage() < maxMileage) {
                break;
            }
            winnerList.add(car.getName());
        }

        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnerList.size() - 1; i++) {
            sb.append(winnerList.get(i)).append(",");
        }
        sb.append(winnerList.getLast());
        return sb.toString();
    }

    public void race() {
        int n = carList.size();
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < n; j++) {
                Car car = carList.get(j);
                car.accelerate(new BrokenAccelerator());
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }
}
