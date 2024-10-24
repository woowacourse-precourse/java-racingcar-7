package racingcar.view;

import java.util.HashMap;
import java.util.List;
import racingcar.controller.domain.Car;

public class OutputView {
    private StringBuilder sb;


    public void printRoundOutput(HashMap<Car, Integer> carToRacingProgress) {
        sb = new StringBuilder();
        for (Car car : carToRacingProgress.keySet()) {
            sb.append(car.getName()).append(" : ").append(carToRacingProgress.get(car)).append("\n");
        }
        System.out.println(sb);
    }

    public void printFinalWinner(List<String> winnerList) {
        System.out.println(ConsoleMessage.FINAL_WiNNER + joinListToString(winnerList));
    }

    public String joinListToString(List<String> list) {
        if (list.size() == 1) {
            return list.getFirst();
        } else {
            return String.join(", ", list);
        }
    }
}
