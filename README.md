# java-racingcar-precourse

## 🚗기능 요구 사항
<ul>
<li>주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.</li>
<li>각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.</li>
<li>자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.</li>
<li>사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.</li>
<li>전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.</li>
<li>자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.</li>
<li>우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.</li>
<li>사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.</li>
</ul>

## 🚗기능 목록 정리

### 🚥입력 기능
<ul>
<li>경주할 자동차 이름 입력 받기(이름은 쉼표(,) 기준으로 구분)
<p>입력 받는 순서대로 리스트에 저장한다.</p>
<p>자동차 이름 양 끝 공백은 제거된다.</p>
<p>자동차 이름 내 공백은 포함되어 저장된다.</p>
<p>자동차 이름에 특수문자는 포함되어 저장된다.</p><br>
</li>
<li>시도할 횟수 입력 받기</li>
</ul>

### 🚥경주 기능
<ul>
<li>각 자동차마다 전진한 횟수 저장하기
<p>전진 횟수에 대한 리스트를 생성하여 관리한다.</p><br>
</li>
<li>전진할지 멈출지 정하기
<p>0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진한다.</p><br>
</li>
<li>자동차가 1대일 경우 경기를 진행하지 않고 바로 우승 처리한다.</li>
</ul>

### 🚥출력 기능
<ul>
<li>차수별 실행 결과 출력하기(자동차 이름, 전진 횟수)</li>
<li>우승자 안내 문구 출력하기(여러 명일 경우 쉼표(,)를 이용하여 구분)</li>
</ul>

## 🚗예외 처리

### 🚥자동차 이름 관련
<ul>
<li>빈 문자열이 입력되는 경우</li>
<li>자동차 이름이 공백인 경우</li>
<li>자동차 이름 길이가 5를 초과하는 경우</li>
</ul>

### 🚥이동 횟수 관련
<ul>
<li>정수가 아닌 값 입력(소수 혹은 숫자 X)</li>
<li>빈 입력</li>
<li>이동 횟수가 1 미만인 경우(음수, 0)</li>
</ul>