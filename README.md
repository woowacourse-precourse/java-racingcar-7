# 자동차 경주 🚗💨

-----
## 🛠️ 기능 요구 사항
#### 1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
```
- 자동차의 개수 제한 없음
```
#### 2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
#### 3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
```
- 이름이 5자가 넘는 경우 예외처리
- 이름이 공백인 경우 예외처리
```
#### 4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
```
- 숫자가 아닌 값을 입력할 경우 예외처리
```
#### 5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
#### 6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
#### 7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
#### 8. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

-----

## 🧮 Model

&emsp;▪️ `StringParser`에서 통해 자동차 이름을 구분하여 `List<String>`으로 `RaceController`로 전달한다.

&emsp; 🚫 다음 경우에 `IllegalArgumentException`
```
1. 자동차 이름이 쉼표가 아닌 문자로 구분되었을 때
2. 자동차 이름에 공백이 입력되었을 때
3. 자동차 이름이 입력되지 않았을 때
```

&emsp;▪️ `CarMovementService`를 통해 자동차의 전진 여부를 확인하고 전진 횟수를 관리한다.

&emsp; 🚫 다음 경우에 `IllegalArgumentException`
```

```

&emsp;▪️ `Validation`을 이용해 예외를 처리한다.



## 🖥️ View

&emsp;▪️ `InputView`클래스를 통해 사용자에게 자동차 이름 문자열과 시도 횟수를  입력 받은 후, `RaceController`로 전달한다.

&emsp;▪️ `OutputView`클래스를 통해 차수별 실행결과와 최종 우승자를 출력한다.


## 🕹️ Controller

&emsp;▪️ `InputView`에서 입력을 받아 `StringParser`로 전달한다.

&emsp;▪️ `StringParser`에서 전달받은 값을 `CarMovementService`로 전달한다.

&emsp;▪️ `CarMovementService`의 자동차별 이동 횟수를 `RaceResult`로 전달한다.

&emsp;▪️ `RaceResult`에서 최종 우승자를 `OutputView`로 전달한다.




