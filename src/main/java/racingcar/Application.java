package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        int carNum = carNames.length;
        Car[] cars = new Car[carNum];

        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());
        for (int i = 0; i < carNum; i++) {
            cars[i] = new Car(carNames[i]);
        }
}
