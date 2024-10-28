# java-racingcar-precourse

## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차가 전진하거나 멈춘다.
- 각 자동차에는 이름을 부여할 수 있고, 전진하는 자동차 출력 시 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구문하고 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야한다.
- 전진하는 조건은 0에서 9사이 무작위 값을 구한 후 4 이상일 경우다.
- 경주 이후 누가 우승했는지 알려준다.
    - 우승자는 한 명 이상일 수 있다.
    - 우승자가 여럿일 경우 쉼표(,)를 이용해 구분한다.
- 사용자가 잘못된 값을 입력할 경우 ```IllegalArgumentException``` 을 발생시킨 후 애플리케이션은 종료된다.

## 입출력 요구 사항
### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
> pobi,woni,jun

- 시도할 횟수
> 5

### 출력
- 차수별 실행 결과
>pobi : --  
woni : ----  
jun : ---

-단독 우승자 안내 문구
>최종 우승자 : pobi

- 공동 우승자 안내 문구
>최종 우승자 : pobi, jun

### 실행 결과 예시
>경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)  
pobi,woni,jun  
시도할 횟수는 몇 회인가요?  
5
>
>실행 결과  
pobi : -  
woni :  
jun : -
>
>pobi : --  
woni : -  
jun : --
>
>pobi : ---  
woni : --  
jun : ---
>
>pobi : ----  
woni : ---  
jun : ----
>
>pobi : -----  
woni : ----  
jun : -----
>
>최종 우승자 : pobi, jun