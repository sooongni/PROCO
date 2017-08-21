package soongni.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soongni.dao.BrandDao;
import soongni.dao.BusiMemberDao;
import soongni.dao.MemberDao;
import soongni.domain.BusiMember;
import soongni.service.BusiMemberService;


@Service
public class BusiMemberServiceImpl implements BusiMemberService {
  @Autowired
  MemberDao memberDao;
  @Autowired
  BrandDao brandDao;
  @Autowired
  BusiMemberDao busiMemberDao;
  
  public List<BusiMember> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return busiMemberDao.selectList(valueMap);
  }

  public void add(BusiMember busiMember) throws Exception {
	 
	  memberDao.insert(busiMember);
	  busiMemberDao.insert(busiMember);
	  System.out.println(busiMember);
	  }
  
  @Override
  public BusiMember brandMemberBrand(int ceono) throws Exception {
  	return busiMemberDao.brandMemberBrand(ceono);
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
public void remove(int no) throws Exception {
	// TODO Auto-generated method stub
	
}
  
  // XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)*/

}







