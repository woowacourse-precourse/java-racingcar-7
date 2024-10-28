package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        //1. 경주할 자동차의 이름을 쉼표 기준으로 구분하여 한줄에 받기
        String inputCar;
        String[] carArr = null;


        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            inputCar = Console.readLine();
            String car = inputCar;
            carArr = car.split(",");

            //1-1. 자동차 이름이 5자를 초과한 경우 에러 출력
            for (String checkCar : carArr) {
                if (checkCar.length()>5){
                    throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
                }
            }

        } catch (IllegalArgumentException e){
            return;
        }

        //feat:2. 시도할 횟수 변수에 횟수 값 입력 받기

        String inputTry;
        System.out.println("시도할 횟수는 몇 회인가요?");
        inputTry = Console.readLine();
        //2-1. 시도할 횟수값이 정수값이 아니면 에러 출력
        try {
            checkIfNumeric(inputTry);
        } catch (IllegalArgumentException e){
            return;
        }

        //3. 전체 자동차를 포함하는 해시맵을 만들고, 키는 자동차의 이름으로 하고 값은 0으로 초기화 한다.
        HashMap<String, String> map = new HashMap<>();
        for (String car : carArr){
            map.put(car, "");
        }

        System.out.println("실행 결과");
        for (String car : carArr){
            //4. 각 자동차의 전진 조건에 대해 정하기 위해 0-9사이의 무작위 값을 구한다.
            Integer pickNum = Randoms.pickNumberInRange(0, 9);
            //5. 만약 무작위 값이 4이상일 경우 전진해야하니, 해당 자동차의 키 값에 대한 value에 +1을 해준다.
            if (pickNum >= 4){
                String value = map.get(car);
                value += "-";
                map.put(car, value);
            }

        }

        //6. 전진 시도 차수별 실행 결과를 출력한다. 자동차 이름 키 값에 대한 밸류값만큼 '-'를 출력한다.
        for (String car : carArr){
            System.out.println(car+" : "+map.get(car));
        }


    }



    public static void checkIfNumeric(String inputTry){
        if (!isNmberic(inputTry)){
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }
    }

    public static boolean isNmberic(String inputTry) {
        return  inputTry != null && inputTry.matches("[+-]?\\d*(\\.\\d+)?");
    }



}
