package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class IOController {

    public static List<String> userListInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String users = Console.readLine();
        return getUserList(users);
    }

    public static List<String> getUserList(String users) {
        return Arrays.stream(users.split(",")).toList();
    }

    public static String tryCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static void printState() {
        System.out.println("실행 결과");
    }

    public static void printCurrentState(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getMoveCount());
        }
        System.out.println();
    }

    public static void printFinalWinner(List<String> winners) {
        String str = String.join(", ", winners);
        System.out.print("최종 우승자 : " + str);
    }
}
