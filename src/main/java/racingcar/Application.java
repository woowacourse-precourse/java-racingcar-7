package racingcar;

public class Application {
    public static void main(String[] args) {
        String[] carNames = CarNameInput.settingCarName();
        Car[] cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);     // 각 자동차 이름으로 Car 객체 생성
        }

        int trialNum = TrialNumInput.settingTrialNum();
        System.out.println("실행 결과");

        for (int gameTrial = 0; gameTrial < trialNum; gameTrial++) {      // 시도 횟수 만큼 play 호출
            Play.play(cars);
        }

        ResultPrinter.printWinner(cars);
    }
}