package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;

public class RacingCar {
    Vector<User> userList;

    RacingCar(){
        userList = new Vector<>();
    }

    public void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        input = input.replaceAll(" ","");
        String userNameArray[] = input.split(",");
        setUserList(userNameArray);

        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            int round = Integer.valueOf(Console.readLine());
            checkRound(round);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private void setUserList(String userNameArray[]) {
        if(userNameArray.length == 0) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < userNameArray.length; i++) {
            if(userNameArray[i].isEmpty()){
                throw new IllegalArgumentException();
            }
            if(userNameArray[i].length() > 5){
                throw new IllegalArgumentException();
            }
            userList.add(new User(userNameArray[i]));
        }
    }

    private void checkRound(int round) {
        if(round < 0){
            throw new IllegalArgumentException();
        }
        if(round == 0){
            System.out.println("경주를 진행하지 않고 종료");
        }
    }
}
