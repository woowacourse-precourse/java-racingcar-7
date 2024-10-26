package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    private static final String FINAL_WINNERS = "최종 우승자 : ";
    private static final String RESULT = "실행 결과";
    private final StringBuilder sb = new StringBuilder();

    public void printEachRound(Cars cars) {
        sb.setLength(0); // 초기화
        sb.append(RESULT).append("\n");
        makeResultOfRound(cars);
        System.out.println(sb);
    }

    private void makeResultOfRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            sb.append(car.getName()).append(" : ");
            for (long i = 0; i < car.getDistance(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }

    }

    public void printWinnersName(Cars cars) {
        sb.setLength(0);

        sb.append(FINAL_WINNERS);
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < carList.size() - 1; i++) {
            sb.append(carList.get(i).getName()).append(", ");
        }
        sb.append(carList.getLast().getName());

        System.out.println(sb);
    }
}