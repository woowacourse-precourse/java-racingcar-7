package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	
    	try{
    		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 자동차 이름은 5자 이하)");
    		String carName = Console.readLine();
    		CarArrayCheck check = new CarArrayCheck();
    		check.carNameSplit(carName);
    	}catch(Exception e){
    		throw new IllegalArgumentException(); 
    	}
    }
}
