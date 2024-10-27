package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    Car[] cars;
    int attempt;
    int carCount;

    void inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        String[] carName = inputCar.split(",");

        this.carCount = carName.length;
        this.cars = new Car[carCount];

        for(int i=0;i<carCount;i++){
            if (carName[i].trim().length() > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");//5글자
            }
            this.cars[i] = new Car(carName[i].trim());
        }
    }

    void inputNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.attempt = Integer.parseInt(Console.readLine());
        System.out.println();
    }


    public void start(){
        inputCar();
        inputNum();
    }

    public static void main(String[] args) {
        new Application().start();
    }
}
