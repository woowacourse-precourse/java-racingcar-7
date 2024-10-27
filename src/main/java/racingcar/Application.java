package racingcar;


import java.util.Scanner;

public class Application {

    Scanner scan = new Scanner(System.in);
    String[] nameList = null;

    void run() {
        getName();
    }

    void getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scan.next();
        nameList = input.split(",");
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }
}
