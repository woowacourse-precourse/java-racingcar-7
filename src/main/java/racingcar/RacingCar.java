package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요");
        String inputCarNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRoofCount = Console.readLine();
    public static class Car {
        private String name;
        private int winningPoint;

        public Car(String name) {
            this.name = name;
            this.winningPoint = 0;
        }

        public void moveForward() {
            winningPoint++;
        }

        public String getName() {
            return name;
        }

        public int getWinningPoint() {
            return winningPoint;
        }
    }
}

