package racingcar;

import java.io.ByteArrayInputStream;

public class RacingCarAppTest {

    public static void run(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        runMain();
        System.setIn(System.in);
    }

    private static void runMain() {
        Application.main(new String[]{});
    }
}
