package racingcar;
import java.util.Scanner;

import com.sun.nio.sctp.SctpChannel;

public class Application {
    public static void main(String[] args) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Scanner sc = new Scanner(System.in);
            String cars_str = sc.nextLine();
            // System.out.println(cars_str);

            System.out.println("시도할 횟수는 몇 회인가요?");
            int cnt = sc.nextInt();
            // System.out.println(cnt);
            
    }
}
