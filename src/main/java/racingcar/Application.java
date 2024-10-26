package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        input.nameAndCurrentCount();

        System.out.println("carList : " + input.getCarList() + ", count : " + input.getCount());

    }
}
