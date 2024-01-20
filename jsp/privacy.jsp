<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/privacy.css" />
<title>Insert title here</title>
</head>
<body>
<%@include file="../jsp/nav.jsp"%>
 <div class="table-box">
      <h1>개인정보 처리방침</h1>
      <table class="privacy-table">
        <thead>
          <tr>
            <th>수집방법</th>
            <th>수집 및 이용목적</th>
            <th>수집항목</th>
            <th>보유 및 이용기간</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>회원가입(필수)</td>
            <td>
              서비스 가입, 개인 식별, 고객 상담, 서비스 이용 철회 처리등의 회원
              관리
            </td>
            <td>- 이름, 아이디, 비밀번호, 이메일주소</td>
            <td rowspan="6" class="privacy-useinfo">
              고객님께서 펫피플에서 제공하는 서비스를 받은동안 고객님의
              개인정보는 펫피플에서 계속 보유하며 서비스 제공을 위해 이용하게
              됩니다.<br /><br />회원 탈퇴 시에는 수집된 개인의 정보가 열람 또는
              이용될 수 없도록 파기합니다.<br /><br />다만, 관계 법령의 규정에
              의하여 보존할 필요성이 있는 경우에는 관계 법령에 따라 보존합니다.
            </td>
          </tr>
          <tr>
            <td>회원가입(선택)</td>
            <td>맞춤형 서비스 제공 및 상품 추천 등 마케팅 활용</td>
            <td>- 이메일 수신 여부, SMS 수신 여부</td>
          </tr>
          <tr>
            <td>상품구매</td>
            <td>
              (1)상품구매 시 배송에 대한 정확한 배송지의 확보, 고지사항 전달,
              본인 의사 확인, 불만 처리 및 원활한 의사 소통 경로의 확보, 새로운
              상품이나 이벤트 정보의 안내<br /><br />(2)애견등록번호가 기입되는
              상품구매시 다음의 정보를 수집하여 이용<br /><br />(3)상품구매에
              대한 결제 및 환불을 위해 다음의 정보를 수집하고 이용
            </td>
            <td>
              - 이름, 휴대전화번호, 이메일주소, 주소<br />- 애견등록번호<br />-
              은행계좌정보, 신용카드정보
            </td>
          </tr>
          <tr>
            <td>맞춤형 서비스 제공과 서비스 개선을 위해 서비스 이용</td>
            <td>
              (1)접속빈도 분석 및 서비스 이용에 대한 통계, 이를 통한 맞춤형
              서비스 제공과 서비스 개선을 위해 서비스 이용시 다음의 정보를 자동
              수집하여 이용<br /><br />(2)서비스 제공과 인구통계학적 분석,
              서비스 방문 및 이용기록의 분석, 맞춤형 서비스 제공 등 신규 서비스
              요소의 발굴 및 기존 서비스 개선 등을 위하여 아래의 정보를 수집하여
              이용
            </td>
            <td>
              - IP주소, 방문일시, 서비스 이용기록, 접속 로그<br />- 성별,
              출생년도 또는 SNS계정으로 간편 가입 시 수집 동의 된 정보 (네이버,
              카카오, 애플)
            </td>
          </tr>
          <tr>
            <td>게시판 글 작성</td>
            <td>게시판에 글 작성 시 다음의 정보를 수집하고 이용</td>
            <td>- 이름</td>
          </tr>
          <tr>
            <td>체험단 신청</td>
            <td>
              체험단 선정, 당첨자 본인 확인 및 발표, 체험 제품 배송 고지 및
              안내사항 전달
            </td>
            <td>
              - 이름, 휴대전화번호, 배송지 주소<br />- 개인 SNS url (선택항목)
            </td>
          </tr>
        </tbody>
      </table>
    </div>
<%@include file="../jsp/footer.jsp"%>
</body>
</html>