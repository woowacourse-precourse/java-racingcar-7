package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutputView {

    public static void resultMessage(){
        System.out.println("\n실행 결과");
    }

    public static String positionToDash(int position){
        return IntStream.range(0,position)
                .mapToObj(i->"-")
                .collect(Collectors.joining());
    }

    public static void printCarPositions(RacingGame racingGame){
        List<Car> cars = racingGame.getCars();
        for(Car car : cars){
            System.out.println(car.getName()+ " : " + positionToDash(car.getPosition()));
        }
        System.out.println();
    }

}
