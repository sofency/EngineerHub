package com.sofency.ssm.controller.back;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.Institude;
import com.sofency.ssm.service.EngineerService;
import com.sofency.ssm.service.InstitudeMajorService;

@Controller
@RequestMapping("/back")
public class BackEngineerController {
	
	 private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private InstitudeMajorService institudeMajorService;
	
	//查询工作室人员的信息返回到官网的后端
	@GetMapping("/engineers/{page}")
	public ModelAndView showEngineerInfoToManager(@PathVariable("page")int page) {
		ModelAndView model = new ModelAndView();
		
		List<Institude> institudes = institudeMajorService.getInstitudes();//获取院系
		PageHelper.startPage(page, 3);//每页显示四个数据
		List<Engineer> list=engineerService.getAll();
		PageInfo<Engineer> pages = new PageInfo<Engineer>(list);
		
		model.addObject("pages", pages);
		model.addObject("EngineerCustom", list);
		model.addObject("institudes", institudes);//获取院系
		model.setViewName("manager/PersonManager");
		return model;
	}
	
	//插入工作室人员的信息
	@ResponseBody
	@PostMapping("/insertEngineer")
	public String insertEngineer(HttpServletRequest request,MultipartFile file,Engineer engineer) throws IllegalStateException, IOException {
		//接受多个文件
		String newImageName = null;
		String realPath = "H:\\temp"; 
        if (!file.isEmpty()) {    
	        File filePath = new File(realPath);//存储文件的路径
	        if(!filePath.exists()) {
	        	filePath.mkdir();
	        }
	        String originalName = file.getOriginalFilename(); 
	        String uuidName = UUID.randomUUID().toString(); 
	        newImageName = uuidName + originalName.substring(originalName.lastIndexOf("."));  
	        File imageFile = new File(realPath + "/"+newImageName);  
	        file.transferTo(imageFile); 
		}
        engineer.setEngineerImgpath(new String(realPath + "/"+newImageName));
        int flag = engineerService.insertEngineer(engineer);
        if(flag>=0) {
        	return "true";
        }else {
        	return "false";
        }
   }

   //根据名字查找用户
	@GetMapping("/engineerhub/{name}")
	@ResponseBody
	public List<Engineer> findEngineerInfoByName(HttpServletRequest request,@PathVariable("name") String username){
		List<Engineer> list = engineerService.findEngineerInfoByName(username);
		return list;
	}	
	
	@RequestMapping("/GetInfo/{id}")
	@ResponseBody
	public Engineer GetInfo(@PathVariable("id") Integer id) {
		return engineerService.GetInfo(id);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String keepInfo(Engineer engineer,MultipartFile file) throws IllegalStateException, IOException {
		//接受多个文件
		String newImageName = null;
		String realPath = "H:\\temp"; 
        if (!file.isEmpty()) {    
	        File filePath = new File(realPath);//存储文件的路径
	        if(!filePath.exists()) {
	        	filePath.mkdir();
	        }
	        String originalName = file.getOriginalFilename(); 
	        String uuidName = UUID.randomUUID().toString(); 
	        newImageName = uuidName + originalName.substring(originalName.lastIndexOf("."));  
	        File imageFile = new File(realPath + "/"+newImageName);  
	        file.transferTo(imageFile); 
		}
        engineer.setEngineerImgpath(new String(realPath + "/"+newImageName));
        engineerService.save(engineer);		
        LOG.info("更新人员信息"+engineer);
        return "true";
	}
	
	@ResponseBody
	@DeleteMapping("/delete/{id}")
	public String deleteInfo(@PathVariable("id") Integer id) {
		int flag = engineerService.delete(id);
		if(flag>=0) {
			return "true";
		}else {
			return "false";
		}
	}
}
