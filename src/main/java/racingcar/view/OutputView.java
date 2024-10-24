package racingcar.view;

import java.util.HashMap;
import java.util.List;
import racingcar.controller.domain.Car;

public class OutputView {

    public void printRoundOutput(HashMap<Car, Integer> carToRacingProgress) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carToRacingProgress.keySet()) {
            sb.append(car.name())
                    .append(" : ")
                    .append(changeNumberToProgressString(carToRacingProgress.get(car)))
                    .append("\n");
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

    private String changeNumberToProgressString(int progressNumber) {
        return "-".repeat(Math.max(0, progressNumber));
    }
}
