package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static Map<String, String> cars = new LinkedHashMap<>();
    public static int N;
    public static void main(String[] args) {
        try {
            input();
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = Console.readLine().split(",");
        for(String car: input){
            cars.put(car, "");
        }

        if(cars.isEmpty() || !isValid()) throw new IllegalArgumentException();

        System.out.println("시도할 횟수는 몇 회인가요?");
        N = Integer.parseInt(Console.readLine());
    }

    public static boolean isValid(){
        for (String car : cars.keySet()) {
            if (car.length() > 5) return false;
        }

        return true;
    }
}
