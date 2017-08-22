package soongni.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soongni.dao.MemberDao;
import soongni.domain.Member;
import soongni.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
 
  @Autowired
  MemberDao memberDao;
  
  public List<Member> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return memberDao.selectList(valueMap);
  }
 
  public void add(Member member) throws Exception {
	    memberDao.insert(member);
	    // 강사 사진 추가
	  }
  
  
  public Member getByEmailPassword(String email, String pwd) throws Exception {
	    HashMap<String,Object> valueMap = new HashMap<>();
	    valueMap.put("email", email);
	    valueMap.put("pwd", pwd);
	    
	    return memberDao.selectOneByEmailPassword(valueMap);
	  }
  
  
  public void delete(int mno) throws Exception {
	  memberDao.delete(mno);
		
	}
  /*public Code get(int no) throws Exception {
    return codeDao.selectOne(no);
  }
  
  public Code getByEmailPassword(String email, String password) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    
    return codeDao.selectOneByEmailPassword(valueMap);
  }
  
  @Override
  public int getSize() throws Exception {
    return codeDao.countAll();
  }


@Override
public void update(Code code) throws Exception {
	// TODO Auto-generated method stub
	
}

@Override

  
  // XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)*/

@Override
public Member passwordCheck(int mno , String pwd) {
	HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("mno", mno);
    valueMap.put("pwd", pwd);
    
    return memberDao.passwordCheck(valueMap);
}

@Override
public void update(Member member) throws Exception {
	memberDao.update(member);
}

@Override
public void photoupload(Member member) throws Exception {
	memberDao.photoupload(member);
	
}

@Override
public Member selectOne(int mno) throws Exception {
	return memberDao.selectOne(mno);
}

}







