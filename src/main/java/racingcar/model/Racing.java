package racingcar.model;

import racingcar.view.View;
import java.util.ArrayList;

public class Racing {
    private final ArrayList<Car> cars = new ArrayList<>();
    private final Integer repeatCount;
    private final View view;

    public Racing(String[] names, Integer repeatCount, View view) {
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.repeatCount = repeatCount;
        this.view = view;
    }

    public void race() {
        view.printOutput("\n실행 결과");
        for(int i = 0; i < repeatCount; i++) {
            for (Car car : cars) {
                car.randForward();
            }
            view.printOutput(formatCarStatus());
        }
        view.printOutput(formatWinners());
    }

    public String formatCarStatus() {
        String carStatus = "";
        for (Car car : cars) {
            carStatus += car.formatName();
            carStatus += " : ";
            carStatus += car.formatDistance();
            carStatus += "\n";
        }

        return carStatus;
    }

    public String formatWinners() {
        ArrayList<String> winnerNames = Car.parseWinnerNames(cars);
        String joinedWinners = String.join(", ", winnerNames);

        return "최종 우승자 : " + joinedWinners;
    }
}
