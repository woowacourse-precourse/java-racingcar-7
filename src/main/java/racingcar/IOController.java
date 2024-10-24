package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class IOController {
    public static String userListInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();

    }
    public static String tryCountInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static void printOutput(ArrayList<String> winners){

        String str = winners.stream().collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : "+ str);

    }
}
