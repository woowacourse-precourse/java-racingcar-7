package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 경주 자동차 리스트, 시도 횟수 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carList = car_input(Console.readLine());
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = count_input(Console.readLine());



    }

    public static List<String> car_input(String input){
        String[] carArray = input.split(",");
        return Arrays.asList(carArray);
    }

    public static int count_input(String input){
        return Integer.parseInt(input);
    }
}


