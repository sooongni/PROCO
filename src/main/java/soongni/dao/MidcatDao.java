package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Midcat;

public interface MidcatDao {
  List<Midcat> selectList(Map<String,Object> valueMap);
}
