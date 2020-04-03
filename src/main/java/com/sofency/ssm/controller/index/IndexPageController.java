package com.sofency.ssm.controller.index;

import com.sofency.ssm.pojo.EngineerCustom;
import com.sofency.ssm.service.interfaces.EngineerService;
import com.sofency.ssm.service.interfaces.FameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author sofency
 * @date 2020/4/2 18:08
 * @package IntelliJ IDEA
 * @description
 */
@Controller
@RequestMapping("/index")
public class IndexPageController {

    FameService fameService;
    EngineerService engineerService;
    @Autowired
    public IndexPageController(FameService fameService, EngineerService engineerService){
        this.fameService= fameService;
        this.engineerService = engineerService;
    }
    //只展示三个大佬
    @RequestMapping("/toIndex")
    public String CodeGod(Model model){
        //选取原则  获奖多
        List<Integer> engineersId = fameService.getThreeId();//获取大佬的账户号
        List<EngineerCustom> engineers = engineerService.selectCodeGod(engineersId);//根据账户号查询信息
        model.addAttribute("engineersGod",engineers);
        return "indexPage/page";
    }
}
