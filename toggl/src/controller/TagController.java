package controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TagService;
import entity.Tag;
@Controller
@RequestMapping(value="/Tag")
public class TagController {
	 TagService tagService = new TagService();
	
	@RequestMapping(value="/getTags")
	@ResponseBody
	public List<Tag>getAllTags(){
		return tagService.getAllTags();
	}
	
	@RequestMapping(value="/addTag")
	public void addTag(
			@RequestParam("tagName") String tagName,
			ModelMap modelmap
			){
		   Tag tag = new Tag();
		   tag.setTagName(tagName);
		   tagService.addTag(tag);
	}
	@RequestMapping(value="/deleteTagById")
	public void deleteTagById(Integer id){
		   tagService.deleteTagById(id);		   
	}
	@RequestMapping(value="/getTagById")
	public Tag getTagById(Integer id){
		   return tagService.getTagById(id);
	}
	
	
	
}