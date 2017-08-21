var userNo=0;
$.getJSON('/auth/userinfo.json', function(result) {
	userNo=result.data.mno
	cartList()
})
var shoppingCart = $('.shopping-cart-items')

function cartList() {
	$("#home_cartBtn").on("click", function() {
		$(".shopping-cart").fadeToggle("fast");
		$.getJSON('/cart/list.json', {'mno' : userNo}, function(result) {
			var templateFn = Handlebars.compile($('#cartlist-template').text())
			var generatedHTML = templateFn(result.data)
			console.log(result.data)// 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
			shoppingCart.text('') // tbody의 기존 tr 태그들을 지우고
			shoppingCart.html(generatedHTML) ;
			$(".getCartnoBtn").click(function(){
				var itemElement = $(this)
				var DeleteForcartNo = itemElement.val()
				var postNo = itemElement.attr('data-postno')
				var favorCartno = itemElement.val()
				$.getJSON('/cart/delete.json', {'cartno': DeleteForcartNo}, function(result) {
					var heart = $('.FavorBtn[data-postno='+ postNo + '] .heartBtn')
					heart.removeClass('fa-heart')
						.addClass('fa-heart-o')
					
					var count = $('.FavorBtn[data-postno='+ postNo + ']').parent().children('.goodCount').text()
						console.log(count)
					$.getJSON('code/favorUpdate.json', {
							'postno' : postNo,
							'good' : (count - 1)
						}, function(result) {
							$('.FavorBtn[data-postno='+ postNo + '] .goodCount').text(result.data)
						}, 'json')
					})//$.getJSON('/cart/delete.json')
				itemElement.parent().parent('.mediabox').remove()
			})//$(".getCartnoBtn")
		});
	})
}

