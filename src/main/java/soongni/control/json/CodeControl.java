package soongni.control.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soongni.domain.Code;
import soongni.service.CodeService;

@RestController
@RequestMapping("/code/")
public class CodeControl {
  
  @Autowired ServletContext servletContext;
  @Autowired CodeService codeService;
  
  @RequestMapping("list")
  public JsonResult list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    
	
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", codeService.list(pageNo, pageSize));
   
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("selectListbysdt")
  public JsonResult selectListbysdt(String sdt) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("selectListbysdt", codeService.selectListbysdt(sdt));
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  
  @RequestMapping("selectListTop5")
  public JsonResult selectListTop5(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("selectListTop5", codeService.selectListTop5(pageNo, pageSize));
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  
  
  @RequestMapping("selectListbyMidno")
  public JsonResult selectListbyMidno(int midno) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("selectListbyMidno", codeService.selectListbyMidno(midno));
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("selectListbyType")
  public JsonResult selectListbyType() throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("selectListbyType", codeService.selectListbyType());
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("selectOnebyBrname")
  public JsonResult selectOnebyBrname(String brname) throws Exception {
	  
	  
	  List<Code> code = codeService.selectOnebyBrname(brname);
	  HashMap<String,Object> dataMap = new HashMap<>();
	  dataMap.put("selectOnebyBrname", code);
	  if (code == null) {
        return new JsonResult(JsonResult.FAIL, brname);
      }
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @CrossOrigin
  @RequestMapping("selectOnebyCode")
  public JsonResult selectOnebyCode(String codeNumber) throws Exception {
	  
	  System.out.printf("코드 적용 들어왔다 %s",codeNumber);
	  Code code = codeService.selectOnebyCode(codeNumber);
	  System.out.printf("코드는 %s",codeNumber);
	  if (codeNumber == null) {
		  System.out.printf("실패했다 %s",codeNumber);
        return new JsonResult(JsonResult.FAIL, codeNumber);
      }
	  System.out.printf("성공했다 %s",code);
      return new JsonResult(JsonResult.SUCCESS, code);
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
 
  @RequestMapping("favorUpdate")
  public JsonResult favorUpdate(Code code) throws Exception {
    codeService.favorUpdate(code);
    int good = code.getGood();
    return new JsonResult(JsonResult.SUCCESS, good);
  }
  
  /*@RequestMapping("detail")
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
  
  @RequestMapping("delete")
  public JsonResult delete(int no) throws Exception {
	  codeService.remove(no);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }  
 */
  @RequestMapping("add")
  public JsonResult add(Code code) throws Exception {
   
  
    
    codeService.add(code);
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









