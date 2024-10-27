package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String carNames = getCarNames();
        int count = getCount();
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInputValue = Console.readLine();
        //입력값 검증
        //return count;
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = Console.readLine();
        //차이름이 5자 이하인지 검사
        return carNames;
    }
}
