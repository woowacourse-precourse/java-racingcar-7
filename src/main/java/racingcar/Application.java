package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();

    String[] racingCarArray = input.split(",");

    List<String> racingCarList = new ArrayList<>();

    try {
        for (String racingCar : racingCarArray) {
            racingCar = racingCar.trim();
            if (racingCar.length()>5){
                throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
            }
            racingCarList.add(racingCar);
        }

        System.out.println(racingCarList);

    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
        }
    }

    private static int inputNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String num = Console.readLine();
        return Integer.parseInt(num);
    }

    private static boolean moveOrNah(){
        int Randint = Randoms.pickNumberInRange(0,9);
        return Randint >= 4;
    }
}