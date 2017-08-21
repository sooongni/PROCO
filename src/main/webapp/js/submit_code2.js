var fiBrname = $('#fiBrname'),
fiTitl = $('.fiTitl'),
fiSdt = $('.fiSdt'),
fiEdt = $('.fiEdt'),
fiCode = $('#outCode'),
fiDscp = $('.fiDscp')
var listBrname = 0;
	$.getJSON('/brand/list.json', function(result) {
		listBrname = result.data.list

		var options = {
			data : listBrname,
			getValue : "brname",

			template : {
				type : "iconRight",
				fields : {
					iconSrc : "logo"
				}
			},

			list : {
				maxNumberOfElements : 4,
				onChooseEvent : function() {
					var value = $("#fiBrname").getSelectedItemData().comno
					console.log(value)
				},

			match : {
					enabled : true
				},

			}
		}
		console.log(options)
		$("#fiBrname").easyAutocomplete(options)
	}, 'json')



var select = $('.SelectCategori')

function displayList(pageNo) {
	$.getJSON('/bigcat/list.json', function(result) {

		var templateFn = Handlebars.compile($('#select-template').text())
		var generatedHTML = templateFn(result.data) 
		select.text('')
		select.html(generatedHTML) 
	}) 
} // 카테고리 대/중분류 리스트

displayList(1)

$('#header_home').click(function() {
	location.href = "home.html"
})
$(".any_publicCode_Container").css('display', '')
$(".busi_publicCode_Container").css('display', 'none')
$(".busi_privateCode_Container").css('display', 'none')
$(".code_specification").css('display', '')
var value = $("#selectCodeType option:selected").val();
var text = $("#selectCodeType option:selected").text();


$("select").on('change', function() {
	value = $("#selectCodeType option:selected").val();
	console.log(value);
	if (value == '0') {
		$(".any_publicCode_Container").css('display', 'none')
		$(".busi_publicCode_Container").css('display', '')
		$(".busi_privateCode_Container").css('display', 'none')
	}
	if (value == '2') {
		$(".any_publicCode_Container").css('display', '')
		$(".busi_publicCode_Container").css('display', 'none')
		$(".busi_privateCode_Container").css('display', 'none')
		
		$('#submitBtn').click(function() {	
	$.post('/code/add.json', {
		'comno' : insertBrname.val(),
		'titl':fiTitl.val(),
		'sdt':fiSdt.val(),
		'edt':fiEdt.val(),
		'code':fiCode.val()
		
	}, function(result) {
		if(result.status == 'success'){

			closeModal()
		}
	}, 'json')
})
	}
	if (value == '1') {
		$(".any_publicCode_Container").css('display', 'none')
		$(".busi_publicCode_Container").css('display', 'none')
		$(".busi_privateCode_Container").css('display', '')
	}
})





$(".checkbox").click(function() {
	//체크했다면 자신을 제외한 다른 체크를 해제
	if ($(this).attr('checked')) {
		$(".checkbox").not(this).attr('checked', '');
	}
});

$modal = $('.modal-frame');

function enterNewConvo() {
  $('.create-chat-input').focus();
}

function closeModal() {
  	$modal.removeClass('active');
    $modal.addClass('leave');
}

$('#fiBrnameSearch').click(function() {
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
    if(e.which === 27) {
      closeModal();
    }
  })
 var inputedBrname = 0;
var insertBrname = $('#insertBrname')
var insertLogo = $('#insertLogo') 
 $("#fiBrnameSearch").click(function(){
	 brname = fiBrname.val()
	console.log(brname)
	   $.getJSON('/brand/listByBrand.json', {'brname': brname}, function(result) {
		   inputedBrname = result.data
		   if(result.status == 'success'){
			   $('#sucOrfailLetter').text("이미 등록되어있는 업체입니다. 새로 추가해 주세요.")
		   }else{
			   $('#sucOrfailLetter').text("없는 브랜드네요. 새로운 브랜드를 추가해주세요.")		   
			   $('#create-brand').click(function() {	
						$.post('/brand/add.json', {
							'brname' : insertBrname.val(),
							'logo':insertLogo.val()
						}, function(result) {
						  if(result.status == 'success'){
							 console.log("성공")
						  }
						 }, 'json')
						})
				   }
				  })	
		  		 })