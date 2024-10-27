package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {

    public void race(){
        System.out.println("실행 결과");
    }

    public void roundResult(List<Car> cars){
        cars.forEach(
                car -> System.out.println(car.toString())
        );
        System.out.println("\n");
    }

    public void raceWinner(List<String> carNames){
        String winners = String.join(", ", carNames);
        System.out.println("최종 우승자 : " + winners);
    }

}
