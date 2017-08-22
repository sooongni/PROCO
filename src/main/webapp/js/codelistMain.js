
var pageNoTag = $('#page-no'),
    tbody = $('.codelist_tbl > tbody'),
    pageSize = 3;


$.getJSON('/auth/userinfo.json', function(result) {
	userType=result.data.type
	userNo = result.data.mno
	
	codeList()
	})

function codeList() {
  $.getJSON('code/list.json', {'mno':userNo} , function(result) {
    var templateFn = Handlebars.compile($('#tbody-template').text())
    var generatedHTML = templateFn(result.data)
    tbody.text('') 
    tbody.html(generatedHTML) ;
  })
}