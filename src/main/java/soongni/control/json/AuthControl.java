package soongni.control.json;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import soongni.domain.Member;
import soongni.service.MemberService;

@RestController
@RequestMapping("/auth/")
@SessionAttributes({"loginMember"})
public class AuthControl {
	@Autowired
	MemberService memberService;
	@RequestMapping(path="login", method=RequestMethod.POST)

	public JsonResult login(String email, String pwd,
			Model model, HttpSession session) throws Exception  {
		System.out.println("로그인들어왓다...");
		Member member = null;
		member = memberService.getByEmailPassword(email, pwd);
		if (member != null) { 
			System.out.println("로그인 성공이다");
			model.addAttribute("loginMember", member);
			return new JsonResult(JsonResult.SUCCESS, "ok");

		} else {
			System.out.println("로그인 실패다");
			return new JsonResult(JsonResult.FAIL, "fail");
		}
	}

	@RequestMapping("logout")
	public JsonResult logout(HttpSession session, SessionStatus status) throws Exception {
		status.setComplete();
		session.invalidate();  
		return new JsonResult(JsonResult.SUCCESS, "ok");
	}

	@RequestMapping("userinfo")
	public JsonResult userInfo(HttpSession session) throws Exception {
		System.out.println("여기까지않옴???");
		Member loginMember = (Member)session.getAttribute("loginMember");
	System.out.println(loginMember);
		return new JsonResult(JsonResult.SUCCESS, loginMember);
	}
}









