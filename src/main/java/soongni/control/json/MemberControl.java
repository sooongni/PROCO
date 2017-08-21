package soongni.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soongni.domain.Member;
import soongni.service.MemberService;

@RestController
@RequestMapping("/member/")
public class MemberControl {
  
  @Autowired ServletContext servletContext;
  @Autowired MemberService memberService;
  
  @RequestMapping("list")
  public JsonResult list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", memberService.list(pageNo, pageSize));
   
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  
  
  @RequestMapping("add")
  public JsonResult add(Member member) throws Exception {
    System.out.println("일반멤버 추가하러왔다.");
    memberService.add(member);
    System.out.println("추가되었다...");
    return new JsonResult(JsonResult.SUCCESS, "ok");
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









