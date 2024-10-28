# java-racingcar-precourse
![image](https://github.com/user-attachments/assets/bc3c4396-ae8b-4282-b217-0672f1be40fb)


# 자동차 경주 게임

# 기능 요구사항

## InputView
- 자동차 이름을 입력받는다.
``` 
pobi,woni,jun
```

- 시도할 횟수를 입력받는다.
``` 
5
```


## OutputView
- 자동차 이름과 위치를 출력한다.
- 자동차 경주가 끝난 후 우승자를 출력한다.
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.
- 자동차 이름과 위치를 출력할 때 자동차 이름과 위치 사이에는 콜론(:)을 넣는다.
- 우승자를 출력할 때는 `최종 우승자`라는 문구를 출력한다.
- 우승자를 출력할 때는 우승자를 쉼표(,)로 구분한다.

```
실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```


## Car
- 자동차는 이름과 위치를 가진다.
- 자동차는 전진 또는 멈출 수 있다.
- 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차가 전진하면 위치를 1 증가시킨다.
- 자동차가 멈추면 위치를 증가시키지 않는다.

## RacingGame
- 자동차 경주 게임을 실행한다.
- 자동차 경주 게임은 자동차 이름과 시도할 횟수를 입력받는다.
- 개별 라운드 진행에 관련한 로직을 처리한다.
- 시도 횟수,가장 멀리 이동한 자동차(들), 현재 게임에 참여 중인 모든 자동차를 반환한다.

## GameController
- 자동차 경주 게임을 제어한다.
- 사용자의 입력을 받아 RacingGame을 실행한다.

## Validator
- 사용자의 입력값이 유효한지 검증한다.
- 사용자의 입력값이 유효하지 않으면 IllegalArgumentException을 발생시킨다.

## ErrorCode & ExceptionHandler
- 사용자의 입력값이 유효하지 않을 경우 ErrorCode를 반환한다.

## Test
- 기능별 단위 테스트를 구현한다.
- 입력받는 값이 유효한지 검증하는 테스트를 구현한다.




