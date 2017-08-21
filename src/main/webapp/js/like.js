function like(){
	$(".FavorBtn").click(function(event) {
	var favorCartno = 0;
	var heartElement = $(this)
	//heartElement.attr('data-isFav') == 'Y'
	var heartCount = 0;
	var heartOnorNot = heartElement.attr('data-isFav') == 'Y' ? 1 : 0
			pushFavorBtn = $(this).val()
			if (heartOnorNot == 0) {
				$.getJSON('/code/favorClicktoCart.json', {'postno' : pushFavorBtn}, function(result) {
					addCartItem = result.data.favorClicktoCart[0]
					plusFaverCount = addCartItem.good + 1
					minusFaverCount = addCartItem.good - 1
					$.post('cart/add.json', {
						'mno' : userNo,
						'postno' : addCartItem.postno,
						'goodyn' : 'Y'
					}, function(result) {
						favorCartno = result.data
						$('.FavorBtn[data-postno='+ addCartItem.postno + ']').attr('data-cartno', favorCartno)
						$.getJSON('code/favorUpdate.json', {
							'postno' : addCartItem.postno,
							'good' : plusFaverCount,
						}, function(result) {
							$(event.target).addClass('fa-heart')
							$(event.target).removeClass('fa-heart-o')
							heartElement.attr('data-isFav', 'Y')
							heartElement.data('cartno', favorCartno)

							$(event.target).parent().parent().children(
							'.goodCount').html(result.data)
						}, 'json')//$.getJSON('code/favorUpdate.json')
					}, 'json')
				})//$.getJSON('/code/favorClicktoCart.json')
			} else {
				$.getJSON('/code/favorClicktoCart.json', {'postno' : pushFavorBtn}, function(result) {
					addCartItem = result.data.favorClicktoCart[0]
					plusFaverCount = addCartItem.good + 1
					minusFaverCount = addCartItem.good - 1
					heartCount = heartElement.data('cartno')
					console.log("!!!!!",heartCount)
					$.post('cart/delete.json', {'cartno' : heartCount}, function() {
						$(event.target).addClass('fa-heart-o')
						$(event.target).removeClass('fa-heart')
						heartElement.attr('data-isFav', 'N')
						heartElement.data('cartno', "")
					}, 'json')
					$.getJSON('code/favorUpdate.json', {
						'postno' : addCartItem.postno,
						'good' : minusFaverCount
					}, function(result) {
						$(event.target).parent().parent().children(
						'.goodCount').html(result.data)
					}, 'json')
				})
			}
}) 
}