package racingcar.view;

import java.util.HashMap;
import java.util.List;
import racingcar.converter.ListToStringConverter;
import racingcar.domain.Car;

public class OutputView {
    private final ListToStringConverter listToStringConverter;

    public OutputView() {
        listToStringConverter = new ListToStringConverter();
    }

    public void printRoundOutput(HashMap<Car, Long> racingProgress) {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingProgress.keySet()) {
            sb.append(car.getName())
                    .append(" : ")
                    .append(listToStringConverter.changeNumberToProgressString(racingProgress.get(car)))
                    .append("\n");
        }
        System.out.println(sb);
    }

    public void printFinalWinner(List<String> winnerList) {
        System.out.println(ConsoleMessage.FINAL_WiNNER + listToStringConverter.joinListToString(winnerList));
    }

}
