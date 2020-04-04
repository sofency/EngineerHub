package com.sofency.ssm.service.impl;
import com.sofency.ssm.mapper.MessageMapper;
import com.sofency.ssm.pojo.Message;
import com.sofency.ssm.service.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author sofency
 * @date 2020/4/1 14:14
 * @package IntelliJ IDEA
 * @description
 */

public class MessageServiceImpl implements MessageService {
    MessageMapper messageMapper;
    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    @Override
    @Cacheable(value = "messages",key = "'message:'+#msgId")
    public Message findById(Integer msgId) {
        return messageMapper.selectByPrimaryKey(msgId);
    }

    @Override
    @CacheEvict(value = "messages" ,allEntries = true)
    public int insertMsg(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    @Cacheable(value = "messages",key = "'AllMessages'")
    public List<Message> getMsgs() {
        return messageMapper.selectByExampleWithBLOBs(null);//查询所有的数据
    }

    @Override
    @CacheEvict(value = "messages" ,key = "'message:'+#msgId")
    public int deleteMsg(Integer msgId) {
        return messageMapper.deleteByPrimaryKey(msgId);
    }
}
