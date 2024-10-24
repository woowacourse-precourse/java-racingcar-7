package racingcar;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        System.out.println("시도할 회수는 몇회인가요?");
        CarRace carRace = new CarRace();
        String result = carRace.play("pobi,woni,jun", "5");
        System.out.format("최종 우승자 : %s\n", result);
    }
}
