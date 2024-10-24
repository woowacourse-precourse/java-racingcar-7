# java-racingcar-precourse
1. 자동차 이름 받기
2. 시도할 횟수 입력 받기
3. 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키며 종료
    - 잘못된 값
        - 이름
            - 6자 초과 (단, 좌우 여백은 trim 처리)
            - 이름이 공백문자 (예시: input이 `delta, ,sigma`)
            - 중복값 발생 (예시: input이 `alpha,alpha,beta`)
        - 시도할 횟수
            - 0 이상의 정수가 아닌 값 (float, 알파벳 등)
            - `int`로 처리 가능한 범위를 넘어서는 정수
4. 차수별 실행 처리
    - 랜덤값 발생
    - 전진 횟수 카운트
5. 차수별 실행 결과 출력
6. 전진 횟수가 최대인 참가자 추출
7. 우승자 출력
---------------------------------------------------------
디렉토리 구조
```bash
├─main
│  └─java
│      └─racingcar
│              Application.java
│              Car.java
│              Input.java
│              Print.java
│              Racing.java
│              Validate.java
│
└─test
    └─java
        └─racingcar
                ApplicationTest.java
                CarTest.java
                InputTest.java
                PrintTest.java
                RacingTest.java
                ValidateTest.java

```