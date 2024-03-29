/**
 * 
 */

// jsp에서의 ${pageContext.request.contextPath}를 js에서 전역변수로 설정
const hostIndex = location.href.indexOf(location.host) + location.host.length;
const contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
// [검색 요청] 버튼 클릭 시 실행할 메서드를 정의합니다.
$(document).ready(function() {
	loadResults(1);
});
$(function() {
	$('#searchBtn').click(function() {
		loadResults(1); // 기본적으로 첫 페이지 로드
	});
});

function loadResults(startNum) {

	$.ajax({
		url: "/search/SearchDb.api",
		type: "get",
		data: {
			keyword: $('#keyword').val(),
			startNum: startNum
			//			displayPage: displayPage
		},
		dataType: "json",
		success: function(data) {
			sucFuncJson(data); // 성공 함수 호출
			createPagination((data.total / 12), startNum); // 페이지네이션 생성, 여기서 5는 총 페이지 수를 의미
		},
		error: errFunc
	});
	return false;
}

// 페이지네이션 생성 함수
// totalPage = 나타날 총 페이지 수
// nowPage = 현재 페이지
// nowPage의 1페이지는 1 2페이지는 13 3페이지는 25 ...
function createPagination(totalPages, nowPage) {
	totalPages = totalPages + 1
	console.log("totalPages : " + totalPages);
	console.log("nowPage : " + nowPage);
	var paginationStr = '';

	let temp = ((nowPage - 1) / 12) + 1; // nowPage = 1 temp = 1, nowPage = 13 temp = 2 
	console.log(nowPage);
	let page = 0;
	page = temp == 0 ? 1 : temp;
	// 한 페이지에 보여줄 항목의 수
	var pageSize = 10;
	// 페이징 처리를 위한 시작 페이지와 끝 페이지 번호를 계산
	let startPage = 1 + 10 * (Math.floor((page - 1) / 10));// page =1 startPage = 1 page = 2 startpage = 1 page = 11 startPage = 11
	console.log("startPage : " + startPage);
	let endPage = startPage + pageSize - 1;
	console.log("endPage : " + endPage);
	// 전체 페이지 수 : totalPages
	endPage = endPage > totalPages ? totalPages : endPage;
	if (page > 10) {
		paginationStr += '<button type="button" class="page-btn" data-page="' + (startPage * 12 - 131) + '">' + '&lt;' + '</button>';
	}
	for (var i = startPage; i <= endPage; i++) {

		if (temp != i) {
			paginationStr += '<button type="button" class="page-btn" data-page="' + (1 + ((i - 1) * 12)) + '">' + i + '</button>';
		} else {
			paginationStr += '<button type="button" class="page-btn1" data-page="' + (1 + ((i - 1) * 12)) + '">' + i + '</button>';
		}

	}
	if (page < totalPages) {
		paginationStr += '<button type="button" class="page-btn" data-page="' + (endPage * 12 + 1) + '">' + '&gt;' + '</button>';
	}


	$('#pagination').html(paginationStr);

	// 페이지 버튼 클릭 이벤트 바인딩
	$('.page-btn').click(function() {
		var page = $(this).data('page');
		window.scrollTo(0, 0);
		loadResults(page); // 해당 페이지의 결과 로드
	});
}
//<input type="hidden" name="boardnum" value=${boardnum }>
// 검색 성공 시 결과를 화면에 뿌려줍니다.
function sucFuncJson(d) {
	var str = "";
	$.each(d.items, function(index, item) {
		// item.discount의 돈 단위로 서식 바꾸기
		console.log("index : " + index);
		// 화폐 정규식 표현
		const discount = item.discount;
		const discount1 = discount.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
		const pubdate = item.pubdate;
		const pubdate1 = pubdate.replace(/(\d{4})(\d{2})(\d{2})/g, '$1-$2-$3');
		str += "<ul>";
		str += "	<input type='hidden' name='isbn' value=" + item.isbn + ">";
		str += '	<input type="hidden" name="description" value="' + item.description + '">';
		str += '	<input type="hidden" name="discount" value="' + discount + '">';
		str += "    <img name='image' id='image' src='" + item.image + "'width='304' height='228' >";
		str += "    <li name='title' id='title'> 제목 : " + item.title + "</li>";
		str += "    <li name='author' id='author' > 저자 : " + item.author + "</li>";
		str += "    <li name='publisher' id='publisher'> 출판사 : " + item.publisher + "</li>";
		str += "    <li name='discount' id='discount'> 가격 : " + discount1 + "원</li>";
		str += "    <li name='pubdate' id='pubdate'> 출간일 : " + pubdate1 + "</li>";
		str += "</ul>";
	});
	$('#searchResult').html(str);
}
// 실패 시 경고창을 띄워줍니다.
function errFunc(e) {
	alert("실패: " + e.status);
}
// ul 태그 안의 내용을 form 태그를 만들어 보냄
$(document).on('click', 'ul', function() {
	var ulElement = $(this); // 클릭된 ul 요소를 가져옵니다.
	// ul 요소 안에 있는 정보들을 가져옵니다.
    var isbn = ulElement.find('input[name="isbn"]').val();
    var description = ulElement.find('input[name="description"]').val();
    var imageSrc = ulElement.find('img[id="image"').attr('src');
    var title = ulElement.find('li[name="title"]').text().replace('제목 : ', '');
    var author = ulElement.find('li[name="author"]').text().replace('저자 : ', '');
    var publisher = ulElement.find('li[name="publisher"]').text().replace('출판사 : ', '');
    var discount = ulElement.find('input[name="discount"]').val();
    if(discount == ' 0원') {
		alert("해당 책은 판매하지 않습니다. 다른 책을 골라 주세요");
		return false;
	}
    var pubdate = ulElement.find('li[name="pubdate"]').text().replace('출간일 : ', '');
	// 새 form 엘리먼트를 생성합니다.
	var form = $('<form></form>');

	// form 속성을 설정합니다.
	form.attr('method', 'post');
	form.attr('action',  '/search/bookDetails.bo');

	// 필드를 생성하고 값을 설정합니다.
	form.append('<input type="hidden" name="isbn" value="' + isbn + '">');
	form.append('<input type="hidden" name="description" value="' + description + '">');
	form.append('<input type="hidden" name="imageSrc" value="' + imageSrc + '">');
	form.append('<input type="hidden" name="title" value="' + title + '">');
	form.append('<input type="hidden" name="author" value="' + author + '">');
	form.append('<input type="hidden" name="publisher" value="' + publisher + '">');
	form.append('<input type="hidden" name="discount" value="' + discount + '">');
	form.append('<input type="hidden" name="pubdate" value="' + pubdate + '">');

	// form을 body에 추가하고 submit 합니다.
	$('body').append(form);
	form.submit();

});

