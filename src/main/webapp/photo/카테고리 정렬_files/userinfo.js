// 로그인 사용자 정보를 가져온다.
$.getJSON('/auth/userinfo.json', function(result) {
	console.log("로그인 되었다..",result)
  if (result.data) {
	  
    $('#header_login').append($('<span>').html('(' + result.data.alias + ')님'))
               .append($('<a>').attr('id','logout-link').attr('href', '#').text('로그아웃'))
    
  }
}) // getJSON()


$(document.body).on('click', '#logout-link', function(event) {
  $.getJSON('/auth/logout.json', function(result) {
	  console.log("로그아웃 되었다",result.data)
    location.href = '../home.html'
  })
})