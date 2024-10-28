package racingcar;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = sc.nextLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = sc.nextInt();
        System.out.println(count);

    }
}
