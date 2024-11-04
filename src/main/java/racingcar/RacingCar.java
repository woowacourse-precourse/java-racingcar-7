package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingCar {
    private final int TOGO = 4;
    public ArrayList<Car> cars;
    public int InputNumber;
    public int MAX = 0;
    public int count=0;



    public RacingCar() {
        cars = new ArrayList<>();
    }

    public void run() {
        inputName();
        inputCount();
        check();
        playAllRound();
        winnerName();
    }

    private void playAllRound() {
        for (int i = 0; i < InputNumber; i++) {
            playOneRound();
        }
    }

    //자동차의 이름을 입력받고 객체에 저장한다.
    private void inputName() {
        System.out.println("자동차의 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분합니다.)");
        String carName[] = Console.readLine().split(",");
        for (int i = 0; i < carName.length; i++) {
            Car car = new Car();
            car.setName(carName[i]);
            car.setCount(0);

            cars.add(car);
        }
    }

    //총 이동 횟수를 입력 받고 저장한다.
    private void inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String s = Console.readLine();
        InputNumber = validationNumber(s);
    }

    //총 이동 횟수의 값을 검증한다.
    private int validationNumber(String input) {
        //입력가능한건 0 이상의 자연수
        try {
            int inputNum = Integer.parseInt(input);
            if (inputNum < 1) {
                throw new IllegalArgumentException("0 이하의 수를 입력할 수 없습니다.");
            }
            return inputNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

    //랜덤 숫자 입력하기
    private void playOneRound() {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9); // 랜덤 수를 가져온다.
            if (random >= TOGO) { // 기준 이상의 값일 경우 전진한다.
                //car의 키값을 1증가시킨다.
                car.setCount(car.getCount() + 1);
            }
        }
        // 해당 차의 상태 정보를 출력한다. 이름 : -
        shownow();
        System.out.println();
    }

    //제일 멀리간 횟수 찾기
    private void winnerNumber() {
        for (Car car : cars) {
            if (car.getCount() > MAX) {
                MAX = car.getCount();
            }
        }
    }

    private void winnerName() {
        List<String> names = new ArrayList<>();
        winnerNumber();
        System.out.print("최종 우승자 : ");
        for (Car car : cars) {
            if (car.getCount() == MAX) {
                names.add(car.getName());
            }
        }

        String namesOutText = String.join(", ", names);
        System.out.print(namesOutText);
    }


    public void shownow() {
        for (Car c : cars) {
            System.out.print(c.getName() + " : ");
            for (int i = 0; i < c.getCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void check() {
        if (cars == null) {
            throw new RuntimeException("자동차가 없습니다.");
        }
    }

}
