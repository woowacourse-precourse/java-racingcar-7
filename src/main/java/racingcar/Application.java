package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("경주 할 자동차 이름을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("시도할 횟수를 입력해주세요.");
        int move = sc.nextInt();
    }
}
