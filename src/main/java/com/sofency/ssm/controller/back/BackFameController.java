package com.sofency.ssm.controller.back;


import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.GetFame;
import com.sofency.ssm.service.interfaces.GetFameService;
import com.sofency.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sofency.ssm.pojo.FameCustom;
import com.sofency.ssm.service.interfaces.FameService;

@Controller
@RequestMapping("/back")
public class BackFameController {
	private final Logger LOG = LoggerFactory.getLogger(BackFameController.class);
	private FameService fameService;
	private GetFameService getFameService;

	@Autowired
	public BackFameController(FameService fameService,GetFameService getFameService) {
		this.fameService = fameService;
		this.getFameService=getFameService;
	}

	//向管理员端发送荣誉的信息
	@RequestMapping("/fame/{page}")
	public ModelAndView showFameToManager(@PathVariable("page") int page) {
		ModelAndView modelAndView = new ModelAndView();
		PageHelper.startPage(page, 3);//每页显示四个数据
		List<FameCustom> fame = fameService.getFameInfoList();
		System.out.println(fame.size());
		PageInfo<FameCustom> pages = new PageInfo<>(fame);
		modelAndView.addObject("pages", pages);
		modelAndView.addObject("fameCustom",fame);
		modelAndView.setViewName("manager/fameManager");
		LOG.info("\n"+ DateUtil.getCurrentTime()+"--查询荣誉信息");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/insertFame")
	public  String insertFame(FameCustom fameCustom){
		//首先根据荣誉名称判断荣誉库里面是否存在荣誉
		Fame fame = fameService.getFameByName(fameCustom.getFameName());
		//如果存在不添加
		GetFame getFame = new GetFame();
		getFame.setGetTime(fameCustom.getGetTime());
		getFame.setEngineerId(Integer.valueOf(fameCustom.getEngineerId()));//设置荣誉获取者的id
		if(fame!=null){
			getFame.setFameId(fame.getFameId());
		}else{//没有荣誉则创建荣誉
			Fame fame1 = new Fame();
			fame1.setFameDescription(fameCustom.getFameDescription());
			fame1.setFameLevel(fameCustom.getFameLevel());
			fame1.setFameName(fameCustom.getFameName());
			int key = fameService.insert(fame1);//返回荣誉的id
			getFame.setFameId(key);
		}
		int flag = getFameService.insert(getFame);
		if(flag==0){
			return "false";
		}else{
			return "true";
		}
	}
	@ResponseBody
	@RequestMapping("/getInfoById")
	public FameCustom getFameCustom(Integer fameId, Integer engineerId){
		System.out.println(fameId+"e"+engineerId);
		FameCustom fameCustom = new FameCustom();
		fameCustom.setEngineerId(engineerId);
		fameCustom.setFameId(fameId);
		FameCustom fameInfo = fameService.getFameInfo(fameCustom);
		if(fameInfo!=null){
			return fameInfo;
		}else{
			return null;
		}
	}
}
