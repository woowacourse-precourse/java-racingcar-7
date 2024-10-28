package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        //1. 경주할 자동차의 이름을 쉼표 기준으로 구분하여 한줄에 받기
        String inputCar;
        String[] carArr = null;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCar = Console.readLine();
        String car = inputCar;
        carArr = car.split(",");

        isValidCars(carArr);

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
        for (String targetCar : carArr){
            map.put(targetCar, "");
        }

        System.out.println("실행 결과");
        //7. 시도할 횟수동안 다음의 4-6과정을 반복한다.
        for (int i = 0; i < parseInt(inputTry); i++) {
            for (String targetCar : carArr) {
                //4. 각 자동차의 전진 조건에 대해 정하기 위해 0-9사이의 무작위 값을 구한다.
                Integer pickNum = Randoms.pickNumberInRange(0, 9);
                //5. 만약 무작위 값이 4이상일 경우 전진해야하니, 해당 자동차의 키 값에 대한 value에 +1을 해준다.
                map = checkPickNum(pickNum, targetCar, map);


            }

            //6. 전진 시도 차수별 실행 결과를 출력한다. 자동차 이름 키 값에 대한 밸류값만큼 '-'를 출력한다.
            for (String targetCar : carArr) {
                System.out.println(targetCar + " : " + map.get(targetCar));
            }
            System.out.println();
        }

        //8. 시도가 끝나면 우승자를 뽑는다. 해시맵에서 value값이 가장 큰 키 값을 최종 우승자로 출력한다.
        Integer totalLength=0;
        for (String targetCar : carArr) {
            if (totalLength <= map.get(targetCar).length()){
                totalLength= map.get(targetCar).length();
            }
        }

        String totalWinner = null;
        for (String targetCar : carArr) {
            if (totalLength == map.get(targetCar).length()){
                if (totalWinner == null){
                    totalWinner = targetCar;
                } else{
                    totalWinner += (", " + targetCar);
                }
            }
        }
        System.out.println("최종 우승자 : "+totalWinner);
    }



    public static void checkIfNumeric(String inputTry){
        if (!isNmberic(inputTry)){
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }
    }

    public static boolean isNmberic(String inputTry) {
        return  inputTry != null && inputTry.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public static boolean isValidCars(String[] carArr){
        try{
            //1-1. 자동차 이름이 5자를 초과한 경우 에러 출력
            for (String checkCar : carArr) {
                checkLengthValidCars(checkCar);
                checkNumericValidCars(checkCar);
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
        return true;
    }

    //feat:1-1. 자동차 이름이 5자를 초과한 경우 에러 출력(함수화)
    public static boolean checkLengthValidCars(String checkCar){
        if (checkCar.length()>5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }else{
            return true;
        }
    }

    //feat:1-2. 자동차 이름이 숫자일 경우 에러 출력(함수화)
    public static boolean checkNumericValidCars(String checkCar){
        if (isNmberic(checkCar)){
            throw new IllegalArgumentException("자동차 이름은 숫자일 수 없습니다.");
        }else{
            return true;
        }
    }

    //feat:1-2. 자동차 이름이 숫자일 경우 에러 출력(함수화)
    public static HashMap<String, String> checkPickNum(Integer pickNum, String targetCar, HashMap<String, String> map) {
        if (pickNum >= 4) {
            String value = map.get(targetCar);
            value += "-";
            map.put(targetCar, value);
        }
        return map;
    }
}
