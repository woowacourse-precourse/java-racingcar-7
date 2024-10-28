package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        CarManager carManager = new CarManager();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> participants = Arrays.stream(input.split(","))
                .map(String::strip)
                .peek(participant ->{
                    if(participant.length()>5){
                        throw new IllegalArgumentException();
                    }
                })
                .collect(Collectors.toList());

        for (String name : participants) {
            carManager.addCar(name, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            carManager.moveCars(participants);
            carManager.printState(participants);
            System.out.println();
        }

        List<String> winners = carManager.getWinners();
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
