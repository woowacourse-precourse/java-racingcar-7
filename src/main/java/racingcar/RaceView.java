package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RaceView {
    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return splitCarNames(input);
    }

    private List<String> splitCarNames(String input){
        String [] names = input.split(",");
        return List.of(names);
    }
    public int getTotalRounds(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
    public void displayRoundResults(List<Car> cars){
        System.out.println("실행 결과");
        for (Car car: cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
    public void displayWinners(List<Car> winners){
        System.out.println("최종 우승자 : " + getWinnersNames(winners));
    }

    public String getWinnersNames(List<Car> winners){
        return String.join(",",winners.stream().map(Car::getName).toList());
    }
}
