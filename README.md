# java-racingcar-precourse
## 기능 목록
### 1. 경주할 자동차 이름 입력 받기
#### (1) 입력 문구 출력
````
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
````
#### (2) 자동차 이름 입력 
````
pobi,woni,jun
````
#### (3) 입력 받은 자동차 이름 검증
이름을 입력 받을 시 다음 조건을 검증한다.
1. 반드시 이름은 영어 소문자으로만 구성되어야 한다.
2. 반드시 이름은 쉼표(,)으로 구분한다. (쉼표 이외의 특수문자는 허용하지 않는다)
3. 입력받은 문자열의 길이는 최대 String 클래스가 표현할 수 있는 문자열 길이로 지정한다.

### 2. 시도할 횟수 입력 받기
#### (1) 시도할 횟수 입력 문구 출력
````
시도할 횟수는 몇 회인가요?
````
#### (2) 시도할 횟수 입력 받기
````
5
````
#### (3) 시도할 횟수 검증하기
횟수를 입력 받을 시 다음 조건을 검증한다.
1. 반드시 자연수이어야 한다.
### 3. 시도 횟수만큼 자동차 경주를 진행한다.
사용자가 입력한 시도 횟수만큼 반복한다.
### 4. 차수별 실행 결과 출력하기
#### (1) 실행 결과 시작 문구 출력
````
실행 결과
````

#### (2) 차수별 실행 결과 출력
````
pobi : --
woni : ----
jun : ---
````
위와 같이 "이름 : -(횟수만큼)" 양식을 지킨다.

#### 5. 우승자 안내 문구를 출력한다
````
최종 우승자 : pobi
````
**단, 우승자가 여러 명일 경우 다음과 같이 출력한다.**
````
최종 우승자 : pobi, jun
````
위와 같이 이름, 이름, 이름, ... 양식을 지킨다.