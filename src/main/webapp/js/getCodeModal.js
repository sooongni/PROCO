
var modal= $('.modal')
var modalClose = $('.btn-close')
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

			var copyCode = result.data.favorClicktoCart[0].code
			$('.btn-close').click(function(){
				$('.modal-wrapper').toggleClass('open');
				$('.page-wrapper').toggleClass('blur-it');
			})

			
			var clipboard = new Clipboard('.btn');

			$('.copiedBtn').css('display','none')
			$('.copyandGetBtn').click(function() {
				 $('.copyandGetBtn').attr('data-clipboard-text', result.data.favorClicktoCart[0].code); 
				    // callback 설정
				    var clipboard = new Clipboard('.copyandGetBtn');
				    clipboard.on('success', function(e) {
				        $(this).css('display','none')
						$('.copiedBtn').css('display','')
				    });
				    clipboard.on('error', function(e) {
				        console.log(e);
				});
			})
		})
	})
}
