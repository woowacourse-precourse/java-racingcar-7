package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String pureInput = getInputCarNames();
    }


    private static String getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNames;
        try {
            carNames = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        return carNames;
    }
}
