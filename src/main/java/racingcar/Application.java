package racingcar;


import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    Scanner scan = new Scanner(System.in);
    String[] nameList = null;
    int count = 0;
    ArrayList<Integer> moveList = new ArrayList<>();

    void run() {
        getName();
        getCount();
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

    void getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = scan.nextInt();
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }
}
