  $('#home_brands_detail').click(function() {
    location.href = "myPageBrand.html"
  })
  $('#myPage_leave').click(function() {
    location.href = "myPage_leave.html"
  })
  $('#mypage_codelist').click(function() {
  location.href = "myPage_codelist.html"
  })
  $('#editProfile').click(function() {
  location.href = "editProfile.html"
  })
  $('#myPage_List_gosubmitCode').click(function() {
  location.href = "submit_code.html"
  })
  
  $('#file-upload').fileupload({
	url: 'member/photoupload.json',        // 서버에 요청할 URL
	dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
	sequentialUploads: false,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
	singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.
	autoUpload: true,        // 파일을 추가할 때 자동 업로딩 하지 않도록 설정.
	disableImageResize: /Android(?!.*Chrome)|Opera/
	.test(window.navigator && navigator.userAgent), // 안드로이드와 오페라 브라우저는 크기 조정 비활성 시키기
	processalways: function(e, data) {
		console.log('fileuploadprocessalways()...');
		console.log(data.files);
	}, 
	submit: function (e, data) { // 서버에 전송하기 직전에 호출된다.
		data.formData = {
				'mno': userNo
		}
		console.log('submit()...');
	}, 
	done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
		console.log(data.result);
		location.reload()
	}

});
