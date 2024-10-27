package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public String[] GetCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return input.split(",");
    }

    public int GetTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void PrintResult(String[] winners){
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.length - 1; i++) {
            System.out.print(winners[i] + ", ");
        }
        System.out.print(winners[winners.length - 1]);
    }
}
