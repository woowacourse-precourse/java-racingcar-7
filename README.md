# java-racingcar-precourse

## 기능 요구 사항
1. 경주할 **자동차 이름**과 **시도할 횟수**를 입력받는다.   
    
> **[입력 형식]**   
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)   
chae,morol   
시도할 횟수는 몇 회인가요?   
3</code> 

   1-1. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 종료되어야 한다.


2. 각 자동차마다 **0에서 9** 사이의 난수를 생성한다.
3. 생성된 난수가 **4 이상**이면 해당 자동차를 **전진**시킨다.
4. 모든 자동차의 1회 시도가 끝나면, 자동차 이름과 함께 **누적 전진**한 칸만큼 "-"를 출력한다.
> **[출력 형식]**   
chae : ---   
morol : --

*(입력받은 시도 횟수만큼 **2, 3, 4**의 과정을 반복한다.)*


5. 경주한 자동차 중 최종적으로 **전진한 값**이 가장 높은 자동차를 우승자로 선정한다.   
   5-1. 여러 자동차가 동시에 가장 높은 값을 가졌을 경우 **공동 우승자**로 선정한다.


6. 우승한 자동차의 이름을 **우승자 안내** 문구와 함께 출력한다.   
> **[출력 형식]**   
최종 우승자 : chae, morol


## 예외 케이스

**[자동차 이름 입력]**
- 쉼표가 포함되지 않은 문자열
- 구분한 결과가 5자 초과
- 비어 있는 값

**[시도할 횟수 입력]**
- 0 또는 음수
- 정수가 아닌 모든 수
- 문자, 문자열 등 숫자가 아닌 값
- 비어 있는 값