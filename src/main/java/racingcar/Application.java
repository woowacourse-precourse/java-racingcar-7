package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        RacingGame game = new RacingGame();
        game.play();
    }

    static class RacingGame {
        private static final int forwardThreshold = 4;

        public void play() {
            System.out.println("\n실행 결과");
        }

        private void playRound() {

        }

        private boolean isMovable() {
            return Randoms.pickNumberInRange(0, 9) >= forwardThreshold;
        }
    }

    static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
        }

        public void move() {
            position++;
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " : " + "-".repeat(position);
        }
    }

}