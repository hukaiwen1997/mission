package service;

import java.util.List;
import org.springframework.stereotype.Service;
import Dao.TagDao;
import entity.Tag;


@Service
public class TagService {
    TagDao tagDao = new TagDao();
    @SuppressWarnings("unchecked")
	public List<Tag>getAllTags() {
		@SuppressWarnings("rawtypes")
		List tags = null;
		try {
			tags= tagDao.findAllTags();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tags;
	}
	public void addTag(Tag tag){ 
		tagDao.saveTag(tag);
	}
   
    public void deleteTagById(Integer id){ 
    	tagDao.deleteTagById(id);
    }
    public Tag getTagById(Integer id){
    	return tagDao.loadTagById(id);
    }
}
