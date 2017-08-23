package soongni.control.json;

import java.io.File;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
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
    System.out.println(member);
    memberService.add(member);
    System.out.println(member);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("passwordCheck")
  public JsonResult passwordCheck(int mno, String pwd) throws Exception {
	  System.out.println(pwd);
	  Member member = null;
	  member = memberService.passwordCheck(mno, pwd);
    if (member == null) {
      return new JsonResult(JsonResult.FAIL, "fail");
    }
    return new JsonResult(JsonResult.SUCCESS, member);
  }
  
  @RequestMapping("selectOne")
  public JsonResult selectOne(int mno) throws Exception {
	  System.out.println(mno);
	  Member member = null;
	  member = memberService.selectOne(mno);
    if (member == null) {
      return new JsonResult(JsonResult.FAIL, "fail");
    }
    return new JsonResult(JsonResult.SUCCESS, member);
  }
  
  @RequestMapping("update")
  public JsonResult update(Member member) throws Exception {
    memberService.update(member);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("delete")
  public JsonResult delete(int mno) throws Exception {
	  memberService.delete(mno);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }  

 
  @RequestMapping("photoupload")
  public JsonResult upload(Member member, MultipartFile[] files) throws Exception {
	String newFilename = this.getNewFilename();
	
    File file = new File(servletContext.getRealPath("/memberprofile/" + newFilename));
    files[0].transferTo(file);
    member.setPic("/memberprofile/" + newFilename);
    
    File thumbnailfile = new File(servletContext.getRealPath("/memberprofile/" + newFilename + "_190"));
    Thumbnails.of(file).size(190, 140).outputFormat("png").toFile(thumbnailfile);
    
    
    memberService.photoupload(member);
    
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
 
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
}









