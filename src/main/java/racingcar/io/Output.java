package racingcar.io;

import java.util.ArrayList;

import static racingcar.util.Racing.judgementWhoIsWin;

public class Output {

    public static String out(String str) {
        return "test";
    }


    public static void printWinner() {
        System.out.println();
        System.out.print("최종 우승자 : ");
        ArrayList<String> strings = judgementWhoIsWin();
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i));
            if(strings.size()-1>i) {
                System.out.print(", ");
            }
        }

    }

}
