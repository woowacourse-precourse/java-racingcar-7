package racingcar.exception;

public enum ErrorCode {


    CANT_CONVERT_TO_INTEGER("사용자의 입력을 숫자로 변환하지 못했습니다");

   private final String message;

   ErrorCode(final String message){
       this.message = message;
   }

   public String getMessage(){
       return this.message;
   }
}
