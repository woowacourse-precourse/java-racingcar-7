package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRacing carRacing = new CarRacing();
        carRacing.init();
    }

    public class Car {
        public Car(String name) {
        }
    }

    public static class CarRacing {

        public void init() {
            String nameInput = Console.readLine();
            convertCarNames(nameInput);
        }

        ArrayList<String> convertCarNames(String nameInput) {
            ArrayList<String> carNames;

            // nameInput이 비어있거나, 공백이거나, 문자+숫자+언더스코어(_)+쉼표(,) 제외하고 존재하는 경우
            if (nameInput.isEmpty() || nameInput.isBlank() || !nameInput.matches("[\\w\\s,]+")) {
                throw new IllegalArgumentException();
            }

            try {
                carNames = new ArrayList<>(Arrays.asList(nameInput.split(",")));

                // 자동차 이름이 하나만 입력된 경우 -> 경주를 진행할 수 없다.
                if (carNames.size() < 2) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            return carNames;
        }
    }
}