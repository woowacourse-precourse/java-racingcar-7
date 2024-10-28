package racingcar.model;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public record HasCarMoved (
    boolean moved
){

  public static HasCarMoved from (boolean moved){
    return new HasCarMoved(moved);
  }
}
