package soongni.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soongni.dao.CartDao;
import soongni.dao.CodeDao;
import soongni.domain.Cart;
import soongni.service.CartService;


@Service
public class CartServiceImpl implements CartService {
 
	  @Autowired
	  CodeDao codeDao;
  @Autowired
  CartDao cartDao;
  
  public List<Cart> list(int mno) throws Exception {
	    return cartDao.list(mno);
	  }

  
  public void add(Cart cart) throws Exception {
	    cartDao.insert(cart);
	  }


  public void remove(int cartno) throws Exception {
	  cartDao.delete(cartno);
	}


@Override
public Cart goodYesorNo(int postno, int mno) throws Exception {
	HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("postno", postno);
    valueMap.put("mno", mno);
    
    return cartDao.goodYesorNo(valueMap);
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







