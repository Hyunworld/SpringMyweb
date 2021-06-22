<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form action="freeUpdate">
                            <div>
                                <label>DATE</label>
                                <p>${vo.regdate }</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${vo.bno }" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' value="${vo.writer }" required>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${vo.title }" required>
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content' required>${vo.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" onclick="location.href = 'freeList'">목록</button>    
                            <button type="submit" class="btn btn-primary">변경</button>
                            <button type="button" class="btn btn-info" onclick="location.href='freeDelete?bno=${vo.bno}'">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
      