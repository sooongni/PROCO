package soongni.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soongni.dao.CodeDao;
import soongni.domain.Code;
import soongni.service.CodeService;


@Service
public class CodeServiceImpl implements CodeService {
 
  @Autowired
  CodeDao codeDao;
  
  public List<Code> list(int mno) throws Exception {
	  return codeDao.selectList(mno);
    
  }
  
  public List<Code> selectListTop5(int pageNo, int pageSize) throws Exception {
	    HashMap<String,Object> valueMap = new HashMap<>();
	    valueMap.put("startIndex", (pageNo - 1) * pageSize);
	    valueMap.put("pageSize", pageSize);
	    
	    return codeDao.selectListTop5(valueMap);
	  }
  
  public void add(Code code) throws Exception {
	    codeDao.insert(code);
	  }

  
  public List<Code> selectOnebyBrname(String brname) throws Exception {
	 return codeDao.selectOnebyBrname(brname);
}
  
  
  public List<Code> favorClicktoCart(int postno) throws Exception {
		 return codeDao.favorClicktoCart(postno);
	}
@Override
public void favorUpdate(Code code) throws Exception {
	codeDao.favorUpdate(code);
	
}

@Override
public List<Code> selectListbysdt(String sdt) throws Exception {
	 return codeDao.selectListbysdt(sdt);
}

@Override
public List<Code> selectListbyMidno(int midno) throws Exception {
	return codeDao.selectListbyMidno(midno);
}

@Override
public List<Code> selectListbyType() throws Exception {
	return codeDao.selectListbyType();
}

@Override
public Code selectOnebyCode(String codeNumber) {
	return codeDao.selectOnebyCode(codeNumber);
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







