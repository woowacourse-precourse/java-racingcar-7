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

    public void printRoundOutput(HashMap<Car, Long> carToRacingProgress) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carToRacingProgress.keySet()) {
            sb.append(car.name())
                    .append(" : ")
                    .append(listToStringConverter.changeNumberToProgressString(carToRacingProgress.get(car)))
                    .append("\n");
        }
        System.out.println(sb);
    }

    public void printFinalWinner(List<String> winnerList) {
        System.out.println(ConsoleMessage.FINAL_WiNNER + listToStringConverter.joinListToString(winnerList));
    }

}
