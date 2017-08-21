var userNo = 0;
	$('.BrandFavorBtn').click(function() {
		alert($(this).val())
	})
	$(function() {
		$('.footer').load("footer.html")
		$('.header').load("header.html")
		$('.notYet').load("notYet.html")
	})

	var urlBrandName = decodeURIComponent(location.href.split('?')[1])
	var offerContainer = $('.offerContainer')
	var brandName = $('.BrandName')
	var BrandDetailLogo = $('.BrandDetailLogo')
	var plusFaverCount = 0;
	var minusFaverCount = 0;
	var pushFavorBrn=0;
	var addCartItem;
	
	function displayList() {
		$.getJSON('/code/selectOnebyBrname.json', {'brname' : urlBrandName}, function(result) {
			var templateFn = Handlebars.compile($('#codeListbyBrand-template')
					.text())
			var generatedHTML = templateFn(result.data)
			offerContainer.text('') // tbody의 기존 tr 태그들을 지우고
			offerContainer.html(generatedHTML);
			
			for (var i = 0; i < result.data.selectOnebyBrname.length; i++) {
				$.getJSON('/cart/goodYesorNo.json', {'postno' : result.data.selectOnebyBrname[i].postno}, function(result2) {
					console.log(result2.data)
					
					if (result2.data == "로그인하세요") {
						return
					}
					if (result2.data) {
						if(result2.data.goodyn=="Y"){
							var favorCartno=result2.data.cartno
							console.log("카트번호는~~~~",favorCartno)
							$('.FavorBtn[data-postno='+ result2.data.postno + '] .heartBtn').addClass('fa-heart')
							$('.FavorBtn[data-postno='+ result2.data.postno + '] .heartBtn').removeClass('fa-heart-o')
							
							
							$('.FavorBtn[data-postno='+ result2.data.postno + ']').attr('data-isFav', 'Y')
							$('.FavorBtn[data-postno='+ result2.data.postno + ']').attr('data-cartno', result2.data.cartno)
						}else if(result2.data.goodyn==undefined){
							$('.heartBtn').addClass('fa-heart-o')
							$('.heartBtn').removeClass('fa-heart')
						    }}
				})//$.getJSON('/cart/goodYesorNo.json')
			  }//for()
			
			 $(".detailAccordion").accordion({
				collapsible : true,
				active : 2
			 })
			
			like()//좋아요 누르기 함수 호출
			
		})//$.getJSON('/code/selectOnebyBrname.json')
		$.getJSON('/brand/listByBrand.json', {
			'brname' : urlBrandName
		}, function(result) {
			var templateFn = Handlebars.compile($('#logobyBrand-template')
					.text())
			var generatedHTML = templateFn(result.data)
			BrandDetailLogo.text('') // tbody의 기존 tr 태그들을 지우고
			BrandDetailLogo.html(generatedHTML);

			var templateFn2 = Handlebars.compile($('#brnamebyBrand-template')
					.text())
			var generatedHTML2 = templateFn2(result.data)
			brandName.text('') // tbody의 기존 tr 태그들을 지우고
			brandName.html(generatedHTML2);

		})
	}//displayList()
	
	displayList()
	
