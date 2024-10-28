package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_NUMBERS = "시도할 회수는 몇회인가요?";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String getCarNames() throws IOException {
        System.out.println(GET_CAR_NAMES);
        return br.readLine();
    }

    public int getTryNumbers() throws IOException {
        System.out.println(GET_TRY_NUMBERS);
        return Integer.parseInt(br.readLine());
    }
}
