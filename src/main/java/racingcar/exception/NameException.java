package racingcar.exception;

public class NameException {

    public void nameException(String carName) {
        if(carName.length()<1){
            System.out.println("이름은 한글자 이상이어야 합니다.");
            throw new IllegalArgumentException();
        }
        if(carName.length()>5){
            System.out.println("이름은 다섯자 이하만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}
