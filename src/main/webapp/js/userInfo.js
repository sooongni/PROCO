var userBrname ;
var userCeoTel;
var userbusino;
var userNo;
var userPic;
var checkOk = false
var userType



$.getJSON('/auth/userinfo.json', function(result) {
	userType=result.data.type
	userNo = result.data.mno
	
	if(userType==1){
		$.getJSON('member/selectOne.json',{'mno':userNo},function(result){
		$('.dropdown').css('display','')
		$('#header_id').append($('<i>').attr('class','fa fa-user').html('&nbsp;'+result.data.alias+'님&nbsp;')).append($('<i>').attr('class','fa fa-angle-down'))
		$('#header_login').remove()
		$('#header_join').remove()
		
		userEmail = result.data.email
		userPic = result.data.pic
		userAlias = result.data.alias

		$('.email').val(userEmail)
		$('.alias').val(userAlias)
		$('#profileImg').attr("src", userPic+"_190.png")
		$('.aliasemailHello').text(userAlias+"님 안녕하세요!")
		
		
		})
	}



	if(userType==2){
		$.getJSON('busimember/brandMemberBrand.json',{'ceono':userNo},function(result){
			$('.dropdown').css('display','')
			$('#header_id').append($('<i>').attr('class','fa fa-user').html('&nbsp;'+result.data.alias+'님&nbsp;')).append($('<i>').attr('class','fa fa-angle-down'))
			$('#header_login').remove()
			$('#header_join').remove()
			
			userEmail = result.data.email
			userPic = result.data.pic
			userAlias = result.data.alias
			userBrname = result.data.brname
			userCeoTel = result.data.ceotel
			userbusino = result.data.busino
			console.log("-------->>>>222",result)
			$('.email').val(userEmail)
			$('.alias').val(userAlias)
			$('.brname').val(userBrname)
			$('.busino').val(userbusino)
			$('.ceotel').val(userCeoTel)
			$('#profileImg').attr("src", userPic+"_190.png")
			$('.aliasemailHello').text(userAlias+"님 안녕하세요!")
		})
	}
}) // getJSON()

$(document.body).on('click', '#logout-link', function(event) {
	$.getJSON('/auth/logout.json', function(result) {
		console.log("로그아웃 되었다",result.data)
		location.href = '../home.html'
	})
})


