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
                    
                    <!--1.검색부분을 폼으로 넘기는데 컴트롤러에서 필요한 값을 hidden으로 처리해서 넘겨줍니다-->
                    <form action="freeList">
		    <div class="search-wrap">
                       <button type="submit" class="btn btn-info search-btn">검색</button>
                       <input type="text" class="form-control search-input" name="searchName" value="${pageVO.cri.searchName }">
                       <select class="form-control search-select" name="searchType"><!-- 키워드 타입 -->
                            <option value="title" ${pageVO.cri.searchType eq 'title' ? 'selected' : '' }>제목</option>
                            <option value="content" ${pageVO.cri.searchType eq 'content' ? 'selected' : '' }>내용</option>
                            <option value="writer" ${pageVO.cri.searchType eq 'writer' ? 'selected' : ''  }>작성자</option>
                            <option value="titcont" ${pageVO.cri.searchType eq 'titcont' ? 'selected' : '' }>제목+내용</option>
                       </select>
                    </div>
                    
                    <input type="hidden" name="pageNum" value="1">
                    <input type="hidden" name="amount" value="10">
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


		    <form action="freeList" name="pageForm">
                    <div class="text-center">
                    <hr>
                    <ul class="pagination pagination-sm">
                    <!--1. 페이지 네이션을 가져옴-->
                    <!-- 2.이전페이지 활성화여부 -->
                    <!-- 3. 다음버튼 활성황 여부 -->
                    <!-- 
                    <c:if test="${pageVO.prev }">
                        <li><a href="freeList?pageNum=${pageVO.startPage-1} & amount=${pageVO.amount }">이전</a></li>
                    </c:if>
                        <c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
                        <li class="${pageVO.pageNum eq num ? 'active' : '' }">
                        	<a href="freeList?pageNum=${num } & amount=${pageVO.amount }">${num }</a
                        	></li>
                        </c:forEach>
                        
                     <c:if test="${pageVO.next }">  
                        <li><a href="freeList?pageNum=${pageVO.endPage + 1 } & amount=${pageVO.amount}">다음</a></li>
                     </c:if>
                     -->
                     <c:if test="${pageVO.prev }">
                        <li><a href="#" data-pagenum="${pageVO.startPage -1 }">이전</a></li>
                    </c:if>
                        <c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
                        <li class="${pageVO.pageNum eq num ? 'active' : '' }">
                        	<a href="#" data-pagenum="${num }">${num }</a
                        	></li>
                        </c:forEach>
                        
                     <c:if test="${pageVO.next }">  
                        <li><a href="#" data-pagenum="${pageVO.endPage + 1 }">다음</a></li>
                     </c:if>
                     
                    </ul>
                    <button type="button" class="btn btn-info" onclick="location.href ='freeRegist' ">글쓰기</button>
                    </div>
                    
                    <input type="hidden" name="pageNum" value="${pageVO.cri.pageNum }">
                    <input type="hidden" name="amount" value="${pageVO.cri.amount }">
                    <input type="hidden" name="searchType" value="${pageVO.cri.searchType }">
                    <input type="hidden" name="searchName" value="${pageVO.cri.searchName }">
                    
                    
		    </form>
                </div>
            </div>
        </div>
	</section>
	
	<script>
		//페이지처리 -
		//모든 a버튼을 눌렀을 때 a가 가지고 있는 pageNum값을 가지고 form태그로 이동하도록 처리
		
		var pagination = document.querySelector(".pagination");
		pagination.onclick = function() {
			
			event.preventDefault();
			if(event.target.tagName != 'A') return;
			//사용자가 클릭한 페이지 번호를 form에 넣고 서브밋을 보냅니다.
			document.pageForm.pageNum.value = event.target.dataset.pagenum;
			document.pageForm.submit();
			
			
		}
	</script>
	
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



