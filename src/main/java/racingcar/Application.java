package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int count = 0;

        Separator separator = new Separator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputNames = Console.readLine();
        String[] names = separator.separate(inputNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String stringCount = Console.readLine();
        count = Integer.parseInt(stringCount);
    }
}
