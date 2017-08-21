
var modal= $('.modal')
var closeModalBtn=false
function getCodeModal() {
	$('.getCodeModal').on('click', function(event) {
		$('.modal-wrapper').toggleClass('open');
		$('.page-wrapper').toggleClass('blur-it');

		$.getJSON('code/favorClicktoCart.json',{'postno':$(this).parent().data("postno")}, function(result){
			console.log("---->", result)
			var templateFn = Handlebars.compile($('#getCodeModal-template').text())
			var generatedHTML = templateFn(result.data)
			modal.text('') // tbody의 기존 tr 태그들을 지우고
			modal.html(generatedHTML) ;


			$('.copiedBtn').css('display','none')
			$('.copyandGetBtn').click(function() {
				$(this).css('display','none')
				$('.copiedBtn').css('display','')
			})
		})
	})
	
	var modalClose = $('.btn-close')
	
	modalClose.click(function(){
		console.log("ㅃㅃㅃㅃ")
	})
}
