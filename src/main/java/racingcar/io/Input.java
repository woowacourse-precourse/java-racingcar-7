package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] carName() throws IllegalArgumentException {
        String str;

        try {
            str = Console.readLine();
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }

        return str.split(",");
    }

    public static int tryNum() throws IllegalArgumentException {
        int n = 0;
        try {
            String str = Console.readLine();
            n = Integer.parseInt(str);
            if(n < 0) {
                throw new IllegalArgumentException();
            }
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }

        return n;
    }
}
