package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,)기준으로 구분");
        String nameInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryInput = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        HashMap<String,Integer> carInfo = delimiterCar(nameInput);

        String character = "-";


        // 게임 진행 상황 표현
        for (int i = 0; i < tryInput; i++) {
            for (Map.Entry<String, Integer> entry : carInfo.entrySet()) {
                carInfo.put(entry.getKey(), entry.getValue()+isForward());
                System.out.println(entry.getKey()+ " : " + character.repeat(entry.getValue()) );

            }
            System.out.println();

        }


    }


    public static HashMap<String,Integer> delimiterCar(String nameInput) {
        StringTokenizer st = new StringTokenizer(nameInput,",");
        HashMap<String,Integer> carInfo = new HashMap<>();

        while (st.hasMoreTokens()) {
            carInfo.put(st.nextToken(),0);
        }
        return carInfo;
    }
    public static int isForward() {

        int i = Randoms.pickNumberInRange(0,9);
//        if (i>=4) return 1;
        return 1;


//    public static int isForward() {
//        int i = Randoms.pickNumberInRange(0,9);
//        return i >= 4;
    }


//    public static String carMove(boolean input) {
//
//    }

}
