package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static class Car {
        private final String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void move() {
            position++;
        }

        public String getPositionDisplay() {
            return "-".repeat(position);
        }
    }
}
