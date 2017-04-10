package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.TagDao;
import entity.Tag;


@Service
public class TagService {
	@Autowired private TagDao tagDao;
    public List<Tag>getAllTags() {
		
		
		return tagDao.getTags();
	}
	public void addTag(Tag tag){ 
		tagDao.addTag(tag);
	}
   
    public void deleteTagById(Integer id){ 
    	tagDao.deleteTagById(id);
    }
    public Tag getTagById(Integer id){
    	return tagDao.getTagById(id);
    }
}
