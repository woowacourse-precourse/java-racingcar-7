package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RaceGame {
    String[] carNamesList;
    int totalCars;
    int totalRounds;

    //사용자의 입력을 받아들이는 메서드
    String getUserInput() throws IOException{
        String userInput;
        //System.out.println("경주에 참여할 자동차의 이름을 입력해주세요. 여러 개일 경우, 각 이름은 comma(,)로 구분해야 합니다. ");

        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        userInput = br.readLine();

        return userInput;
    }

    //사용자의 입력에서 이름을 추출해 배열로 저장하는 메서드
    void getNamesList(String input){
        //null 예외 처리 성공
        //comma 기준으로 구분 성공
        try{
            carNamesList = input.split(",");
            totalCars = carNamesList.length;
        } catch (NullPointerException e){
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }

        //이름의 앞,뒤 공백 제거 완료
        //빈 문자열일 경우 예외 처리, 빈 문자열이 리스트 중간에 있어도 예외 처리
        //공백으로 이루어진 문자열일 경우 예외 처리, 공백 문자열이 리스트 중간에 있어도 예외 처리
        for (int i = 0; i < totalCars; i++){
            carNamesList[i] = carNamesList[i].trim();

            if (carNamesList[i].isEmpty()){
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }

            if (carNamesList[i].matches("^( )+$")){
                throw new IllegalArgumentException("입력값이 공백으로 이루어져 있습니다.");
            }
        }
    }

    void getTotalRounds(String userInput){
        try{
            this.totalRounds = Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if (totalRounds < 1){
            throw new IllegalArgumentException();
        }
    }

}
