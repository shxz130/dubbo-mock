package com.github.dumock.service.db;

import com.github.dumock.copy.DuMockBeanCopyUtils;
import com.github.dumock.mapper.bean.CallRecordDO;
import com.github.dumock.mapper.bean.FacadeDO;
import com.github.dumock.service.db.bean.CallRecord;
import com.github.dumock.service.db.bean.Facade;
import com.github.jettyrun.common.utils.type.ObjectUtils;

/**
 * Created by jetty on 18/7/16.
 */
public interface CallRecordService {


    public default CallRecord convertDO2BO(CallRecordDO callRecordDO){
        CallRecord callRecord= DuMockBeanCopyUtils.copyOne2One(callRecordDO, CallRecord.class);
        if(!ObjectUtils.isEmpty(callRecord)){
            callRecord.setCallStatus(CallRecord.CallStatus.valueOf(callRecordDO.getCallStatus()));
            callRecord.setIsMock(CallRecord.IsMock.valueOf(callRecordDO.getIsMock()));
            callRecord.setIsTimeOut(CallRecord.IsTimeOut.valueOf(callRecordDO.getIsTimeOut()));
        }
        return callRecord;
    }

    public default CallRecordDO convertBO2DO(CallRecord callRecord){
        CallRecordDO callRecordDO= DuMockBeanCopyUtils.copyOne2One(callRecord, CallRecordDO.class);
        if(!ObjectUtils.isEmpty(callRecord)){
            callRecordDO.setCallStatus(callRecord.getCallStatus().name());
            callRecordDO.setIsMock(callRecord.getIsMock().name());
            callRecordDO.setIsTimeOut(callRecord.getIsTimeOut().name());
        }
        return callRecordDO;
    }
}
