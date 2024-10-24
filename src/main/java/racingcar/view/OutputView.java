package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String RESULT_ALERT = "실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String BAR = "-";
    private static final String WINNER_ALERT = "최종 우승자 : ";

    public void printResult(Cars cars){
        System.out.println(RESULT_ALERT);
        StringBuilder stringBuilder = new StringBuilder();

        cars.getCars().forEach(car ->{
            stringBuilder.append(car.getName()+":");
            stringBuilder.append(BAR.repeat(car.getDistance()));
            stringBuilder.append(NEW_LINE);
        });

        System.out.println(stringBuilder);
    }

}
