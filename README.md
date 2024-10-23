<table border="2" style="border-collapse: collapse; text-align: left;">
  <thead>
    <tr style="background-color: #5F5E5E;">
      <th style="padding: 10px;">구분</th>
      <th style="padding: 10px;">기능</th>
      <th style="padding: 10px;">상세 기능</th>
      <th style="padding: 10px;">작동 순서</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="7" style="padding: 10px;">입력<br>(Input)</td>
      <td style="padding: 10px;">자동차 이름 입력<br>(inputCars)</td>
      <td style="padding: 10px;">
        <ul>
            <li>콘솔 입력 후 쉼표(,) 기준으로 분할</li>
            <li>문자열 리스트의 요소별 유효성 체크</li>
        </ul>
      </td><td style="padding: 10px;">
        <ol>
            <li>콘솔 입력 후 쉼표(,) 기준으로 분할</li>
            <li>입력 중 에러 발생시 예외 던지기</li>
            <li>입력 값이 공백이라면 예외 던지기</li>
            <li>문자열 리스트의 요소별 유효성 체크</li>
            <li>해당 요소가 공백이라면 제거</li>
            <li>해당 요소의 길이가 5 초과라면 예외 던지기</li>
            <li>해당 요소가 쉼표(,)가 아닌 구분자를 가지고 있다면 예외 던지기</li>
            <li>문자열 리스트 반환</li>
        </ol>
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">시도 횟수 입력<br>(inputNumTry)</td>
      <td style="padding: 10px;">
        <ul>
            <li>콘솔 입력 후 정수형 변수에 저장</li>
        </ul>
      </td><td style="padding: 10px;">
        <ol>
            <li>콘솔 입력 후 쉼표(,) 기준으로 분할</li>
            <li>입력 중 예외 발생(실수, 문자 입력)시 예외 던지기</li>
            <li>입력 값이 0 이하일 경우 예외 던지기</li>
            <li>정수값 반환</li>
        </ol>
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">쉼표(,)가 아닌 구분자 입력시 예외 처리<br>(commaX)</td>
      <td style="padding: 10px;">
        <ul>
            <li>모든 나라(언어)의 문자, 숫자, 공백을 제외한 나머지 입력시 예외 던지기</li>
        </ul>
      </td><td style="padding: 10px;"></td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">입력된 값이 없으면 예외 처리<br>(noValueEntered)</td>
      <td style="padding: 10px;">
        <ul>
            <li>리스트의 크기가 1이고, 요소가 공백일 경우 예외 던지기</li>
        </ul>
      </td><td style="padding: 10px;"></td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">5글자 초과 시 예외 처리<br>(zeroLess)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력받은 문자열의 길이가 5 초과시 예외 던지기</li>
        </ul>
      </td><td style="padding: 10px;"></td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">시도 횟수가 0 이하이면 예외 처리<br>(over5)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력받은 정수값이 0 이하일 경우 예외 던지기</li>
        </ul>
      </td><td style="padding: 10px;"></td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">입력 값 공백 삭제<br>(noValueDelete)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력된 문자열이 공백일 경우 리스트에서 요소 삭제</li>
        </ul>
      </td><td style="padding: 10px;"></td><!------------------------------------------------->
    </tr>
    <!--------------------(새로운 Class)----------------------------->
    <tr>
      <td rowspan="1" style="padding: 10px;">전진, 멈춤 판단<br>(DetermineRandomNum)</td>
      <td style="padding: 10px;">랜덤하게 뽑은 수가 4이상인지 판단<br>(randomMore4)</td>
      <td style="padding: 10px;">
        <ul>
            <li>0~9 사이에서 무작위 값 구하기</li>
            <li>4이상인지 판단하기</li>
        </ul>
      </td><td style="padding: 10px;">
        <ol>
            <li>각 자동차의 전진/멈춤 결과 저장할 새로운 boolean 형 리스트를 0으로 초기화하여 생성</li>
            <li>랜덤 수 받기</li>
            <li>랜덤 수가 4 이상인지 판단</li>
            <li>4 이상일 경우 해당 요소의 값 +1</li>
            <li>전진/멈춤 결과 저장한 리스트 반환</li>
        </ol>
      </td>
    </tr>
    <!--------------------(새로운 Class)----------------------------->
    <tr>
      <td rowspan="2" style="padding: 10px;">결과 출력<br>(Result)</td>
      <td style="padding: 10px;">진행 결과 출력<br>(printOngoing)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력받은 리스트의 수만큼 "-" 출력</li>
        </ul>
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">우승자 출력<br>(printWinner)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력받은 리스트에서 가장 큰 값을 가지는 항목(여러개 가능) 출력</li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>