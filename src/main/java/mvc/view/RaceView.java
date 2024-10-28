package mvc.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Car;

public class RaceView {

    public List<String> showRegistrationPage(){
        this.printRegistrationGuideMessage();
        String rawCarList = Console.readLine();

        return this.transformRawCarNamesToCarNameList(rawCarList);
    }

    public int showRaceStageSettingPage(){
        this.printRaceStageSettingGuideMessage();
        String strStage = Console.readLine();

        return this.transformStageToInt(strStage);
    }

    public void printStageState(int stageLevel){
        System.out.println("\n"+"#Stage-" + stageLevel);
    }

    public void printCarState(Car car){
        String moveChart = transformToChart(car.getMove());
        System.out.println(car.getName() + " : " + moveChart);
    }

    public void printRaceResult(List<Car> winnerList){
        if(winnerList == null || winnerList.isEmpty()){
            System.out.println("winnerList is null or empty. winnerList must have data less than 1.");
            throw new IllegalArgumentException("innerList is null or empty");
        }

        StringBuilder result = new StringBuilder();
        for(Car car : winnerList){
            result.append(car.getName()).append(",");
        }

        String winners =  result.substring(0 , result.length() -1);

        System.out.println("최종 우승자 : " + winners);
    }

    void printRegistrationGuideMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    void printRaceStageSettingGuideMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    List<String> transformRawCarNamesToCarNameList(String rawCars){

        if(rawCars.isEmpty()){
            System.out.printf("input cars is empty. : %s",rawCars);
            throw new IllegalArgumentException("input cars is empty");
        }

        String[] carNameList = rawCars.split(",");

        for(String carName : carNameList){
            validateCarNameLength(carName);
        }


        return new ArrayList<String>(Arrays.asList(carNameList));
    }

    void validateCarNameLength(String carName){
        int maxSize = 5;

        if(carName.isEmpty()){
            System.out.println("car name is empty.");
            throw new IllegalArgumentException("car name is empty.");
        }

        //validate blank
        if(carName.isBlank()){
            System.out.println("car name is blank.");
            throw new IllegalArgumentException("car name is blank.");
        }

        //validate encoded
        try {
            byte[] utf8Bytes = carName.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException("input cars can't be encoded to utf-8. please check it");
        }

        if(carName.length() > maxSize){
            System.out.printf("car name is over max length. : %s",carName);
            throw new IllegalArgumentException("car name is over max length");
        }
    }

    int transformStageToInt(String strStage){

        validateStage(strStage);

        return Integer.parseInt(strStage);
    }

    void validateStage(String strStage){
        int stage = 0;

        //validate numeric string
        try {
            stage = Integer.parseInt(strStage);
        }catch (NumberFormatException e){
            System.out.printf("stage is not number. input : %s",strStage);
            throw new IllegalArgumentException("stage is not number");
        }

        //validate range
        BigInteger bigIntStage = new BigInteger(strStage);
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger minInt = BigInteger.valueOf(Integer.MIN_VALUE);
        if(bigIntStage.compareTo(maxInt)>0
                || bigIntStage.compareTo(minInt) < 0){
            System.out.printf("stage is out of int type rage. stage : %d",bigIntStage);
            throw new IllegalArgumentException("stage is out of int type rage");
        }

        /*TODO
         * -stage가 0일때는 어떻게 처리해야하는가?
         * */

        //validate positive
        if(stage < 0){
            System.out.printf("stage is out of range. stage : %d",stage);
            throw new IllegalArgumentException("stage is out of rage");
        }
    }

    String transformToChart(int move){
        StringBuilder chart = new StringBuilder();
        Character marker = '-';

        for(int i = 0; i < move; ++i){
            chart.append(marker);
        }

        return chart.toString();
    }




}
