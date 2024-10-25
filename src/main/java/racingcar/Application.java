package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO : refactoring
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        String[] carName = inputCar.split(",");
        // TODO: 글자수 체크, IllegalArgumentException 발생
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());
    }
}
