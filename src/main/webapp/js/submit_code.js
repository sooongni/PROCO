$(function(){
	$('.header_Container').load("header.html")	
})


var fiBrname = $('#fiBrname'),
fiTitl = $('.fiTitl'),
fiTitl2 = $('.fiTitl2'),
fiSdt = $('.fiSdt'),
fiEdt = $('.fiEdt'),
fiSdt2 = $('.fiSdt2'),
fiEdt2 = $('.fiEdt2'),
fiCode = $('.outCode'),
fiCode2 = $('.outCode2'),
fiDscp = $('.fiDscp'),
fiDscp2 = $('.fiDscp2')


var userNo = 0;
$.getJSON('/auth/userinfo.json', function(result) {
	userNo=result.data.mno
})


var listBrname = 0;
var comnovalue = 0; 
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
				maxNumberOfElements : 8,
				onChooseEvent : function() {
					comnovalue = $("#fiBrname").getSelectedItemData().comno
				},

				match : {
					enabled : true
				},

			}
	}
	$("#fiBrname").easyAutocomplete(options)
}, 'json')

var midnoValue = 0;
var busicomno=0;
$(".SelectCategori").on('change', function() {
	midnoValue = $(".SelectCategori option:selected").val()
})

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
var Typevalue = $("#selectCodeType option:selected").val();
var text = $("#selectCodeType option:selected").text();

$("#selectCodeType").on('change', function() {
	Typevalue = $("#selectCodeType option:selected").val();

	if (Typevalue == '0') {
		$(".any_publicCode_Container").css('display', 'none')
		$(".busi_publicCode_Container").css('display', '')
		$(".busi_privateCode_Container").css('display', 'none')
		
		var a = userNo
		console.log("mno---->aaa",a)

		$.getJSON('busimember/brandMemberBrand.json',{'ceono':a},function(result){
			console.log(result)
			$('#busiMemberbrandName').val(result.data.brname)
			$('#busiMemberbrandName').attr('data-comno', result.data.comno)
			busicomno= $('#busiMemberbrandName').data("comno")
		})
		
		
	}if (Typevalue == '1') {
		$(".any_publicCode_Container").css('display', '')
		$(".busi_publicCode_Container").css('display', 'none')
		$(".busi_privateCode_Container").css('display', 'none')
	}
})


$('#submitBtn').click(function() {
	console.log(fiSdt2.val(), fiEdt2.val())
	if (Typevalue == '0') {
		$.post('/code/add.json', {
			'mno':userNo,
			'comno' : busicomno,
			'midno':midnoValue,
			'titl':fiTitl2.val(),
			'sdt':fiSdt2.val(),
			'edt':fiEdt2.val(),
			'code':fiCode2.val(),
			'dscp': fiDscp2.val(),
			'type':Typevalue
		}, function(result) {
			if(result.status == 'success'){
				location.href="myPage_codelist.html"
			}
		}, 'json')
	}

	if (Typevalue == '1') {
		$.post('/code/add.json', {
			'mno':userNo,
			'comno' : comnovalue,
			'midno':midnoValue,
			'titl':fiTitl.val(),
			'sdt':fiSdt.val(),
			'edt':fiEdt.val(),
			'code':fiCode.val(),
			'dscp': fiDscp.val(),
			'type':Typevalue		
		}, function(result) {
			if(result.status == 'success'){
				location.href="myPage_codelist.html"
			}
		}, 'json')
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
	$.getJSON('/brand/listByBrand2.json', {'brname': brname}, function(result) {
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
					}
				}, 'json')
			})
		}
	})	
})


