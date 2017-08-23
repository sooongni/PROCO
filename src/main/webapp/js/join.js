$modal = $('.modal-frame');

function enterNewConvo() {
	$('.create-chat-input').focus();
}

function closeModal() {
	$modal.removeClass('active');
	$modal.addClass('leave');
}

$('#brnameSearch').click(function() {
	$modal.toggleClass('active');
	$modal.removeClass('leave');
	enterNewConvo();
})

$('.modal-overlay').click(function() {
	closeModal();
})

$('#close').click(function() {
	closeModal();
})

$(document).keyup(function(e) {
	if (e.which === 27) {
		closeModal();
	}
})

var fiBrname = $('#brname')
var insertBrname = $('#insertBrname')
var insertLogo = $('#insertLogo')
var brname = 0;
var joinComno = 0;
$('#brnameSearch').click(function() {

	brname = fiBrname.val()
	$.getJSON('/brand/listByBrand2.json', {
		'brname' : brname
	}, function(result) {
		console.log(result)
		var inputedBrname = result.data.brname
		if (result.status =='success') {
			$('#sucOrfailLetter').text("이미 등록되어있는 업체입니다. 다시 조회해 주세요.")
			joinComno = result.data.comno
		} 

		if (result.status =='fail'){
			$('#sucOrfailLetter').text("등록되어있지 않은 업체입니다. 추가하시겠습니까?")
			insertBrname.val(inputedBrname)

			$('#create-brand').click(function() {
				$.post('/brand/add.json', {
					'brname' : insertBrname.val(),
					'logo' : insertLogo.val()
				}, function(result) {
					if (result.status == 'success') {
						joinComno = result.data
						closeModal()
					}
				}, 'json')
			})
		}
	})
})

var fiEmail = $('.email'),
fiPwd = $('#pwd'), 
fiType = $('.memberType'), 
fiBrname = $('#brname'), 
fiBusinessNumber = $('#businessNumber'), 
fiCeotel = $('#ceotel'),
fiAlias = $('#alias'),
fiTypeNumber = 1;
var realEmail;
var realPwd;
var realAlias;
var authCode = null;

$(".sign-in-form2").css('display', 'none')
var businessJoinSquare = false

function doOpenCheck(b) {
	console.log("---->",b.value);
	fiTypeNumber = b.value
	if (b.value == 2) {
		businessJoinSquare = true
	} else {
		businessJoinSquare = false
	}
	for (var i = 0; i < fiType.length; i++) {
		if (fiType[i] != b) {
			fiType[i].checked = false;
		}
	}
}


$('.join-btn').on('click', function() {
	if(authTrue==true){
		realEmail=$(this).parent().children().children('.email').val()
		realPwd=$(this).parent().children().children('.pwd').val()
		realAlias=$(this).parent().children().children('.alias').val()
		if (fiTypeNumber == 1) {
			console.log("일반멤버포스트단계다.")
			$.post('/member/add.json', {
				'email' : realEmail,
				'pwd' : realPwd,
				'alias' :realAlias,
				'type' : fiTypeNumber
			}, function(result) {
				console.log(result.status)
				location.href = 'home.html'
			}, 'json')
		} else if (fiTypeNumber == 2) {
			$.post('/busimember/add.json', {
				'email' : realEmail,
				'pwd' : realPwd,
				'alias' : realAlias,
				'type' : fiTypeNumber,
				'comno' : joinComno,
				'busino' : fiBusinessNumber.val(),
				'ceotel' : fiCeotel.val()
			}, function(result) {
				location.href = 'home.html'
			}, 'json')
		}
	}//if authTrue가 true 일때만 
	else{
		alert("이메일 인증이 완료되지 않았습니다.")
	}
})



$('.emailAuthBtn').click(function(){
	realEmail=$(this).parent().parent().children('.email').val()
	var a = parseInt(Math.random()*8+1)*1000
	var b = parseInt(Math.random()*9)*100
	var c = parseInt(Math.random()*9)*10
	var d = parseInt(Math.random()*9)
	authCode = a + b + c + d
	console.log(authCode);

	emailjs.init("user_wVlMBEHmBUU8WA0yGJJ90");
	emailjs.send("soongni","emailcertification",{authCode: authCode, email: realEmail})
	.then(function(response) {
		console.log("SUCCESS. status=%d, text=%s", response.status, response.text);
	}, function(err) {
		console.log("FAILED. error=", err);
	})
})

var inputedAuthCode = $('.authCode')
var authTrue ;

$(".emailAuthCheckBtn").on('click', function() {
	inputedAuthCode=$(this).parent().parent().children('.authCode').val()
	if(authCode == inputedAuthCode) {
		authTrue = true
		alert("인증에 성공했습니다.")
	} else  {
		authTrue = false
		alert("인증에 실패했습니다.")
	}
})
