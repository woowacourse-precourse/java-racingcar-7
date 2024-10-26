package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {
    /*
    클래스 변수, 상수

    인스턴스 변수

    생성자
     */
    static final int MAX_NAME = 5;

    List<String> carNames = new ArrayList<String>();
    List<Car> cars = new ArrayList<Car>();

    public void game(){
        int count;
        String input;

        input = inputCars();
        carNames =inputCarNames(input); //이름 리스트 생성
        count = inputCount();
        cars = addCars(carNames);
        play(count,cars);


    }
    /*
    실행 결과
    wo: -
    po:
    메소드 구분
     */
    public void play(int count,List<Car> cars){
        System.out.println("실행결과");
        for(int i =0; i<count ; i++){
            //여기부터
            for(Car car : cars) {
                printGame(car);
            }
            System.out.println();
            //여기 구분
        }
    }
    private void printGame(Car car){
        car.move();
        car.getPosition();
        System.out.print(car.name + " : ");
        for(int i = 0; i< car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public int inputCount(){
        System.out.println("시도할 횟수는 몇 회 인가요");
        String input = Console.readLine();
        return isVaildNum(input);
    }

    public List<String> inputCarNames(String input) {
        String[] names = input.split(",");
        for (int i =0 ; i<names.length; i++) {
            names[i] = names[i].trim();
            isVaildNameMax(names[i]);
        }
        return Arrays.asList(names);
    }
    public List<Car> addCars(List<String> carNames){
        for(String carName : carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
        return  cars;
    }
    private void isVaildNameMax(String name) {
        if (name.length() > MAX_NAME || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 입력해주세요.");
        }
    }
    private int isVaildNum(String input){
        try{
            int count = Integer.parseInt(input);
            isVaildPositive(count);
            return count;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
    private void isVaildPositive(int count){
        if(count<0){
            throw new IllegalArgumentException("0보다 큰 수를 입력해야합니다.");
        }
    }

}
