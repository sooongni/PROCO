var home_categori_detail = $("#home_categori_detail")
var home_brands_detail = $("#home_brands_detail")
var home_openCategori= $("#home_openCategori")
var home_popular_categori = $("#home_popular_categori" )
var home_openBrands = $("#home_openBrands")
var home_popular_brands = $("#home_popular_brands" )

var swiper = new Swiper('.swiper-container', {
	pagination: '.swiper-pagination',
	paginationClickable: true,
	loop: true,
	centeredSlides: true,
	autoplay: 2500,
	speed:2500,
	autoplayDisableOnInteraction: false

});

$('#home_gotoSubmmit').click(function () {
	location.href="submit_code.html"
})


$('#home_categori_detail').click(function () {
	location.href="alignCategori.html"
})

var top1table=$('.home_responsive1')
var top5table=$('.home_responsive2')
var newpromotable = $('.home_newPromo')
var plusFaverCount = 0;
var minusFaverCount = 0;
var addCartItem;
var onlyProcoItemContainer = $('.onlyProcoItemContainer-template')


$(function(){
	$.getJSON('code/selectListTop5.json',function(result){
		var templateFn = Handlebars.compile($('#top1-template').text())
		var templateFn2 = Handlebars.compile($('#top5-template').text())
		var generatedHTML = templateFn(result.data)
		var generatedHTML2 = templateFn2(result.data)
		top1table.text('') // tbody의 기존 tr 태그들을 지우고
		top1table.html(generatedHTML) ;
		top5table.text('') // tbody의 기존 tr 태그들을 지우고
		top5table.html(generatedHTML2) ;
		
		//like() //좋아요 기능 호출
		
		for (var i = 0; i < result.data.selectListTop5.length; i++) {
			$.getJSON('/cart/goodYesorNo.json', {'postno' : result.data.selectListTop5[i].postno}, function(result2) {
				if (result2.data == "로그인하세요") {
					return
				}
				if (result2.data) {
					if(result2.data.goodyn=="Y"){
						var favorCartno=result2.data.cartno
						$('.FavorBtn[data-postno='+ result2.data.postno + '] .heartBtn').addClass('fa-heart')
						$('.FavorBtn[data-postno='+ result2.data.postno + '] .heartBtn').removeClass('fa-heart-o')

						$('.FavorBtn[data-postno='+ result2.data.postno + ']').attr('data-isFav', 'Y')
						$('.FavorBtn[data-postno='+ result2.data.postno + ']').attr('data-cartno', result2.data.cartno)
					}else if(result2.data.goodyn==undefined){
						$('.heartBtn').addClass('fa-heart-o')
						$('.heartBtn').removeClass('fa-heart')
					}}
			})//$.getJSON('/cart/goodYesorNo.json')
		}
	})//$.getJSON('code/selectListTop5.json'



	$.getJSON('code/selectListbysdt.json',function(sdtresult){
		var templateFn = Handlebars.compile($('#newpromo-template').text())
		var generatedHTML = templateFn(sdtresult.data)
		newpromotable.text('') // tbody의 기존 tr 태그들을 지우고
		newpromotable.html(generatedHTML) ;
	})

	$.getJSON('code/selectListbyType.json',function(typeresult){
		var templateFn = Handlebars.compile($('#onlyPromo-template').text())
		var generatedHTML = templateFn(typeresult.data)
		onlyProcoItemContainer.text('') // tbody의 기존 tr 태그들을 지우고
		onlyProcoItemContainer.html(generatedHTML) ;
		like() //좋아요 기능 호출
		getCodeModal()//코드 모달 호출

		for (var i = 0; i < typeresult.data.selectListbyType.length; i++) {
			$.getJSON('/cart/goodYesorNo.json', {'postno' : typeresult.data.selectListbyType[i].postno}, function(result2) {
				if (result2.data == "로그인하세요") {
					return
				}
				if (result2.data) {
					if(result2.data.goodyn=="Y"){
						var favorCartno=result2.data.cartno
						$('.FavorBtn[data-postno='+ result2.data.postno + '] .heartBtn').addClass('fa-heart')
						$('.FavorBtn[data-postno='+ result2.data.postno + '] .heartBtn').removeClass('fa-heart-o')
						$('.FavorBtn[data-postno='+ result2.data.postno + ']').attr('data-isFav', 'Y')
						$('.FavorBtn[data-postno='+ result2.data.postno + ']').attr('data-cartno', result2.data.cartno)
					}else if(result2.data.goodyn==undefined){
						$('.heartBtn').addClass('fa-heart-o')
						$('.heartBtn').removeClass('fa-heart')
					}}
			})//$.getJSON('/cart/goodYesorNo.json')
		}//for
	})
})

