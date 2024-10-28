package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printCarNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResult(List<Car> carList){
        for(Car car: carList){
            System.out.println(car.name + " : " + "-".repeat(car.distance));
        }
        System.out.println();
    }

    public void printWinner(List<Car> carList){
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winners = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
