package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Iterator;
import java.util.List;

public class OutputView {

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String DELIMITER = ":";
    private static final String SPLITOR = ",";

    private static final String START_COMMAND="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNTS="시도할 횟수는 몇 회인가요?";
    private static final String RACING_PROCESS="실행 결과";
    private static final String RACING_WINNER="최종 우승자 : %s";

    public static void printStartCommand(){
        System.out.println(START_COMMAND);
    }

    public static void printRacingCounts(){
        System.out.println(RACING_COUNTS);
    }

    public static void printRacingProcess(){
        System.out.println();
        System.out.println(RACING_PROCESS);
    }

    public static void printRacingWinner(String result){
        System.out.printf(RACING_WINNER,result);
    }

    public static void printState(Cars cars) {
        List<Car> carList=cars.getCars();

        carList.
                stream()
                .forEach(car -> {
                    System.out.println(car.getName() + SPACE + DELIMITER + SPACE + car.getState());
                });
        System.out.println(BLANK);
    }
}
