package soongni.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soongni.service.BigcatService;

@RestController
@RequestMapping("/bigcat/")
public class BigcatControl {
  
  @Autowired ServletContext servletContext;
  @Autowired BigcatService bigcatService;
  
  @RequestMapping("list")
  public JsonResult list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", bigcatService.list(pageNo, pageSize));
   
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  /*@RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    Code code = codeService.get(no);
    if (code == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, code);
  }
  
  
  
 
 */
 
  
}









