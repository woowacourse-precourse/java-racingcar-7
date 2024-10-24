package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String[] cars = input.split(",");
        String inputNum = Console.readLine();
        int count = Integer.parseInt(inputNum);
        int mem1 = 0;
        int mem2 = 0;
        int mem3 = 0;

        while(count >0) {
            int a = Randoms.pickNumberInRange(0, 9);
            int b = Randoms.pickNumberInRange(0, 9);
            int c = Randoms.pickNumberInRange(0, 9);

            if (a >= 4) {
                mem1++;
            }
            if (b >= 4) {
                mem2++;
            }
            if (c >= 4) {
                mem3 ++;
            }
            System.out.print(cars[0] +" : " );
            for (int i = 0; i <mem1; i++) {
                System.out.print("-");
            }
            System.out.println();

            System.out.print(cars[1] +" : " );
            for (int i = 0; i <mem2; i++) {
                System.out.print("-");
            }
            System.out.println();

            System.out.print(cars[2] +" : " );
            for (int i = 0; i <mem3; i++) {
                System.out.print("-");
            }
            System.out.println();


            System.out.println();
            count --;
        }

    }
}

