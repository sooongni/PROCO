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
			var inputedBrname = result.data

			if (result.data == "success") {
				$('#sucOrfailLetter').text("이미 등록되어있는 업체입니다. 다시 조회해 주세요.")
			} else {
				$('#sucOrfailLetter').text("등록되어있지 않은 업체입니다. 추가하시겠습니까?")
				insertBrname.val(inputedBrname)

				$('#create-brand').click(function() {
					$.post('/brand/add.json', {
						'brname' : insertBrname.val(),
						'logo' : insertLogo.val()
					}, function(result) {
						if (result.status == 'success') {

							console.log(result)
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
		fiCeotel = $('#ceotel')
		fiAlias = $('#alias')

	var fiTypeNumber = 0;
	
	$(".sign-in-form2").css('display', 'none')
	var businessJoinSquare = false
	function doOpenCheck(b) {

		console.log("----><",b.value);
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
		console.log("회원타입", fiTypeNumber)
		if (fiTypeNumber == 1) {
			console.log(fiEmail.val())
			$.post('/member/add.json', {
				'email' : fiEmail.val(),
				'pwd' : fiPwd.val(),
				'alias' : fiAlias.val(),
				'type' : fiTypeNumber
			}, function(result) {
				console.log(result.status)
				location.href = 'home.html'
			}, 'json')
		} else if (fiTypeNumber == 2) {
			console.log("비지니스멤버포스트단계다.")
			$.post('/busimember/add.json', {
				'email' : fiEmail.val(),
				'pwd' : fiPwd.val(),
				'alias' : fiAlias.val(),
				'type' : fiTypeNumber,
				'comno' : joinComno,
				'busino' : fiBusinessNumber.val(),
				'ceotel' : fiCeotel.val()
			}, function(result) {
				location.href = 'home.html'
			}, 'json')
		}
	})
	
	var authCode = null;
	$('.emailAuthBtn').click(function(){
		if(fiEmail.val() == '') {
			console.log("이메일을 입력해주세요")
		}else{
			var a = parseInt(Math.random()*8+1)*1000
			var b = parseInt(Math.random()*9)*100
			var c = parseInt(Math.random()*9)*10
			var d = parseInt(Math.random()*9)
			authCode = a + b + c + d
			console.log(authCode);
			
			emailjs.init("user_wVlMBEHmBUU8WA0yGJJ90");
			emailjs.send("soongni","template_R5qMCjvf",{authCode: authCode, email: fiEmail.val()})
			.then(function(response) {
			   console.log("SUCCESS. status=%d, text=%s", response.status, response.text);
			}, function(err) {
			   console.log("FAILED. error=", err);
			})
	  }//else
	})
	
	var inputedAuthCode = $('.authCode')
	var authTrue ;
	$(".emailAuthCheckBtn").on('click', function() {
		if(authCode == inputedAuthCode.val()) {
			authTrue = true
			alert("인증에 성공했습니다.")
		} else  {
			authTrue = false
			alert("인증에 실패했습니다.")
		}
	})
