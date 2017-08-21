var comnovalue;
var brandNamevalue;
var homeSearch=$("#home_search");
$('#header_login').click(function () {
  location.href="auth/login.html"
})

$('#header_home').click(function () {
  location.href="home.html"
})

$("#header_about").on("click" ,function(){
  if (this.hash !== "") {
    event.preventDefault();
    var hash = this.hash;
    $('html, body').animate({
      scrollTop: $(hash).offset().top
    }, 400, function(){
      window.location.hash = hash;
    });
  }
});


$("#header_contact").on("click" ,function(){

  if (this.hash !== "") {
    event.preventDefault();
    var hash = this.hash;
    $('html, body').animate({
      scrollTop: $(hash).offset().top
    }, 400, function(){
      window.location.hash = hash;
    });
  } 
});



$('#header_submitCode').click(function () {
  location.href="submit_code.html"
})


$('.fa fa-heart').click(function () {
  location.href="mypage.html"
})



$('#home_schBtn').click(function () {
	
if(brandNamevalue==null){
	alert("검색어를 입력해 주세요.")
}else{
	location.href="BrandDetail.html?"+brandNamevalue
 }
})

$('#header_logo').click(function () {
  location.href="home.html"
})


$('#header_join').click(function () {
  location.href="join.html"
})


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
					comnovalue = homeSearch.getSelectedItemData().comno
					brandNamevalue = homeSearch.getSelectedItemData().brname
				},
				onKeyEnterEvent: function() {
					brandNamevalue = homeSearch.getSelectedItemData().brname
					location.href="BrandDetail.html?"+brandNamevalue
				},
				match : {
					enabled : true
				},

			}
	}
	homeSearch.easyAutocomplete(options)
}, 'json')
