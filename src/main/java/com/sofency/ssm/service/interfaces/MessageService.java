package com.sofency.ssm.service.interfaces;


import com.sofency.ssm.pojo.Message;

import java.util.List;

/**
 * @author sofency
 * @date 2020/4/1 14:13
 * @package IntelliJ IDEA
 * @description
 */
public interface MessageService {
    Message findById(Integer msgId);

    public int insertMsg(Message message);

    List<Message> getMsgs();

    int deleteMsg(Integer msgId);
}
