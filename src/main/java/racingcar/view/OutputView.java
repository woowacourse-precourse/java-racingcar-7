package racingcar.view;

import static racingcar.util.Delimiter.COMMA;
import static racingcar.util.MoveSymbol.DASH;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OutputView {

    private final String FINAL_WINNER = "최종 우승자 : ";

    public void printWinningCars(Set<String> winningCars) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(COMMA.getDelimiter() + " ", winningCars));
    }

    public void printOneRoundResult(Map<String, Integer> racingCar) {
        for (Entry<String, Integer> carEntry : racingCar.entrySet()) {
            printOneCarResult(carEntry);
        }

        System.out.println();
    }

    private void printOneCarResult(Entry<String, Integer> carEntry) {
        String carName = carEntry.getKey();
        Integer nowScore = carEntry.getValue();

        System.out.println(String.format("%s : %s", carName, DASH.getSymbol().repeat(nowScore)));
    }
}
