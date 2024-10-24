package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String BAR = "-";
    private static final String WINNER_ALERT = "최종 우승자 : ";

    public void printResult(Cars cars){
        StringBuilder stringBuilder = new StringBuilder();

        cars.getCars().forEach(car ->{
            stringBuilder.append(car.getName()+":");
            stringBuilder.append(BAR.repeat(car.getDistance()));
            stringBuilder.append(NEW_LINE);
        });

        System.out.println(stringBuilder);
    }

    public void printWinner(List<String> winner){
        System.out.println(WINNER_ALERT);
        String winnerName = String.join(", ", winner);
        System.out.println(winnerName);
    }
}
