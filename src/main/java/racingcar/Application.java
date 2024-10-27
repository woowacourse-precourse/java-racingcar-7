package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Util.getInputValue();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Util.getInputValue();

        race.run(inputCars, inputCount);
    }
}
