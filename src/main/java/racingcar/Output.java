package racingcar;

import java.util.List;

public class Output {

    public void printRoundResult(List<Car> cars){
        for (Car car: cars){
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners){
        String winnerNames = String.join(", ",
                            winners.stream()
                                .map(Car::getName)
                                .toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
