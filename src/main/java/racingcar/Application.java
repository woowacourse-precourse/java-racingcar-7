package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {

        // 자동차 이름 입력하기
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = sc.nextLine();

        //이동을 시도할 횟수 입력하기
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = sc.nextInt();

        //쉼표 구분자를 이용하여 입력한 자동차를 구별하고 배열에 넣기
        String[] cars = carName.split(",");

        // 0~9 사이에 무작위 값 생성하기
        int ranNum;
        ranNum = Randoms.pickNumberInRange(0, 9);
        System.out.println(ranNum);
    }
}
