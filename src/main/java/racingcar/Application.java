package racingcar;
import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

            //경주할 자동차 이름 받기
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Scanner sc = new Scanner(System.in);
            String cars_str = sc.nextLine();
       
            //시도할 횟수 입력 받기
            System.out.println("시도할 횟수는 몇 회인가요?");
            int cnt = sc.nextInt();

            //쉼표(,) 구분자 이용해서 배열에 넣기기
            String[] cars = cars_str.split(",");

            //0~9 사이에 랜덤한 숫자 구하기
            Random random = new Random();   
            int advance_number = random.nextInt(10);
    }

}
