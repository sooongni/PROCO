    $(window).scroll(function() {
      var height = $(document).scrollTop();
      console.log(height);
      if (height > 245) {
        $(".alignCategori_menuBar_Container").css({
          'position': 'fixed'
        }).css({
          'top': '0'
        });
      } else {
        $(".alignCategori_menuBar_Container").css({
          'position': 'absolute'
        })
      }
    });

    $('.header').load("header.html")
    $('.slide_container').load("cart.html")
    $('.footer').load("footer.html")
    $('.notYet').load("notYet.html")
  
   
var ul = $('#cssvmenu > ul' )
var urlcartNo = decodeURIComponent(location.href.split('?')[1])

  function displayList(pageNo) {
  $.getJSON('bigcat/list.json', function(result) {
    console.log(result);
    var templateFn = Handlebars.compile($('#ul-template').text())
    var generatedHTML = templateFn(result.data) 
    ul.text('')
    ul.html(generatedHTML) 

  
  }) 
} // displayList()

displayList()