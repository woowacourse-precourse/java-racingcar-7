package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView {
    private static final String GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_NUMBERS = "시도할 회수는 몇회인가요?";

    private BufferedReader br;

    public String getCarNames() throws IOException {
        System.out.println(GET_CAR_NAMES);
        return br.readLine();
    }

    public int getTryNumbers() throws IOException {
        System.out.println(GET_TRY_NUMBERS);
        return Integer.parseInt(br.readLine());
    }
}
