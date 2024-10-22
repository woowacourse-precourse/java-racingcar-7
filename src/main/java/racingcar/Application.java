package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    class Car{
        private String name;
        private int position = 0;

        public Car(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public int getPosition(){
            return position;
        }

        public void move(){
            position++;
        }

        public String displayPosition(){
            return "-".repeat(position);
        }
    }
}
