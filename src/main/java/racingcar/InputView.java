package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int getCarNum() {
        System.out.println("자동차는 몇대인가요?");

        int carNum = Integer.parseInt(Console.readLine());
        return carNum;
    }

    public static int getTryNum() {
        System.out.println("몇 번 시도하시겠습니까?");
        int tryNum = Integer.parseInt(Console.readLine());
        return tryNum;
    }

    public static List<String> getCarName() {
        System.out.println("자동차 이름을 입력하세요.(,)을 기준으로 구분: ");
        String carName = Console.readLine();
        String[] carArray = carName.split(",");

        return Arrays.stream(carArray)
                .map(String::trim)
                .toList();
    }

}
