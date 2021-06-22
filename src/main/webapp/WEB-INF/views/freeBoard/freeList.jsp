<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
    <section>
        <div class="container-fluid">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <hr>
                    
                    <!--form select를 가져온다 -->
                    <form>
		    <div class="search-wrap">
                       <button type="button" class="btn btn-info search-btn">검색</button>
                       <input type="text" class="form-control search-input">
                       <select class="form-control search-select">
                            <option>제목</option>
                            <option>내용</option>
                            <option>작성자</option>
                            <option>제목+내용</option>
                       </select>
                    </div>
		    </form>
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="vo" items="${list }">
                            <tr>
                                <td>${vo.bno }</td>
                                <td><a href="freeDetail?bno=${vo.bno }">${vo.title }</a></td>
                                <td>${vo.writer }</td>
                                <td>
                                	<fmt:formatDate value="${vo.regdate }" pattern="yyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                	<fmt:formatDate value="${vo.updatedate }" pattern="yyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>


                    <!--페이지 네이션을 가져옴-->
		    <form>
                    <div class="text-center">
                    <hr>
                    <ul class="pagination pagination-sm">
                        <li><a href="#">이전</a></li>
                        <li  class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">다음</a></li>
                    </ul>
                    <button type="button" class="btn btn-info" onclick="location.href ='freeRegist' ">글쓰기</button>
                    </div>
		    </form>
                </div>
            </div>
        </div>
	</section>
	
	<script>
		window.onload = function() {
				
			if(history.state == '') return; //메시지를 출력했다면 함수종료
			
			var msg = '<c:out value="${msg }" />'
			if(msg != '') {
				alert(msg);
				//기존 기록을 삭제하고 새로운 기록을 추가(이렇게 변경된 값은 history.state)
				history.replaceState('', null, null); //브라우저 기록 컨트롤(추가할데이터, 제목, url주소)
				}
		}
	</script>



