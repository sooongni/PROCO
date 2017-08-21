package soongni.control.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soongni.domain.Cart;
import soongni.domain.Member;
import soongni.service.CartService;

@RestController
@RequestMapping("/cart/")
public class CartControl {
  
  @Autowired ServletContext servletContext;
  @Autowired CartService cartService;
  
  @RequestMapping("list")
  public JsonResult list(int mno) throws Exception {
	  List<Cart> cart = cartService.list(mno);

	  HashMap<String,Object> dataMap = new HashMap<>();
	  dataMap.put("cartlist", cart);
	  if (cart == null) {
        return new JsonResult(JsonResult.FAIL, mno);
      }
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("goodYesorNo")
  public JsonResult goodYesorNo(int postno, HttpSession session) throws Exception {
	  Member member = (Member) session.getAttribute("loginMember");
	  if(member == null){
		    return new JsonResult(JsonResult.SUCCESS, "로그인하세요");
	  }
	  Cart cart = cartService.goodYesorNo(postno, member.getMno());
    return new JsonResult(JsonResult.SUCCESS, cart);
  }
  
  @RequestMapping("add")
  public JsonResult add(Cart cart) throws Exception {
    cartService.add(cart);
    int cartno = cart.getCartno();
    return new JsonResult(JsonResult.SUCCESS, cartno);
  }
  
  /* @RequestMapping("selectOnebyBrname")
  public JsonResult selectOnebyBrname(String brname) throws Exception {
	  

	  List<Code> code = codeService.selectOnebyBrname(brname);
	  HashMap<String,Object> dataMap = new HashMap<>();
	  dataMap.put("selectOnebyBrname", code);
	  if (code == null) {
        return new JsonResult(JsonResult.FAIL, brname);
      }
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
 
  @RequestMapping("favorClicktoCart")
  public JsonResult selectOnebyBrname(int postno) throws Exception {
	  

	  List<Code> code = codeService.favorClicktoCart(postno);
	  HashMap<String,Object> dataMap = new HashMap<>();
	  dataMap.put("favorClicktoCart", code);
	  if (code == null) {
        return new JsonResult(JsonResult.FAIL, postno);
      }
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
 
 @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    Code code = codeService.get(no);
    if (code == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, code);
  }
  
  @RequestMapping("update")
  public JsonResult update(Code code) throws Exception {
    codeService.update(code);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
   */
  @RequestMapping("delete")
  public JsonResult delete(int cartno) throws Exception {
	  System.out.println("지우러요청이왔나여?1");
	  cartService.remove(cartno);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }  

  
  /*@RequestMapping("upload")
  public JsonResult upload(MultipartFile[] files) throws Exception {
    ArrayList<String> fileList = new ArrayList<>();
    for (MultipartFile file : files) {
      if (file.isEmpty())
        continue;
      String filename = getNewFilename();
      file.transferTo(new File(servletContext.getRealPath("/teacher/photo/" + filename)));
      fileList.add(filename);
    }
    return new JsonResult(JsonResult.SUCCESS, fileList);
  }
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }*/
}









