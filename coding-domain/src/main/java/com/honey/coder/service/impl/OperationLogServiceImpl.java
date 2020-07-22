package com.honey.coder.service.impl;

import com.honey.coder.mapper.LogOperationMapper;
import com.honey.coder.model.LogOperation;
import com.honey.coder.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zlzhou
 */
@Service
@Slf4j
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private LogOperationMapper logOperationMapper;

    @Override
    public Long insert(LogOperation logOperation) {
        logOperationMapper.insert(logOperation);
        return logOperation.getId();
    }
}
