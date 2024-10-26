package racingcar.exception;

public class IllegalArgumentException extends RuntimeException{

   public IllegalArgumentException(ErrorCode code){
       super(code.getMessage());
   }
}
