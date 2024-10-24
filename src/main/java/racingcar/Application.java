package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 경주 자동차 리스트, 시도 횟수 입력
        List<String> carList = car_input();
        int tryCount = count_input();

    }

    public static List<String> car_input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carArray = Console.readLine().split(",");
        List carList = Arrays.asList(carArray);

        return carList;
    }

    public static int count_input(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String num = Console.readLine();
        int count = Integer.parseInt(num);
        return count;
    }
}


