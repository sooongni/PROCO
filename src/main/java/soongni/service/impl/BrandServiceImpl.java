package soongni.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soongni.dao.BrandDao;
import soongni.domain.Brand;
import soongni.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {
 
  @Autowired
  BrandDao brandDao;
  
  public List<Brand> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return brandDao.selectList(valueMap);
  }

@Override
public void add(Brand brand) {
	 brandDao.insert(brand);
	// TODO Auto-generated method stub
	
}

public Brand listByBrand2(String brname) throws Exception {
    return brandDao.listByBrand2(brname);
  }

public List<Brand> listByBrand(String brname) throws Exception {
    return brandDao.listByBrand(brname);
  }

public Brand get(int no) throws Exception {
    return brandDao.selectOne(no);
  }
 /*
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







