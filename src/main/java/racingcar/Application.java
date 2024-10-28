package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_car = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input_race_count = Console.readLine();

        try{
            String racingWinner = CarRace.race(input_car, input_race_count);
            System.out.println("최종 우승자 : " + racingWinner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
