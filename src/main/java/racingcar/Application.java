package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        StringTokenizer tokenizer = new StringTokenizer(Console.readLine(), ",");
        String car1 = tokenizer.nextToken();
        String car2 = tokenizer.nextToken();
        String car3 = tokenizer.nextToken();
        System.out.println("시도할 홧수는 몇 회인가요?");
        int trial = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");


    }
}
