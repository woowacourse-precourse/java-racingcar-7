package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static List<String> cars;
    public static void main(String[] args) {

    }

    public static void input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        cars = Arrays.asList(input.split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int N = Integer.parseInt(Console.readLine());
    }
}
