package com.github.jettyrun.common.utils.sequence;

import com.github.jettyrun.common.utils.date.DateFormatUtils;
import com.github.jettyrun.common.utils.net.NetUtils;
import com.github.jettyrun.common.utils.type.StringUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jetty on 18/2/11.
 */
public class IdGenerator {

    private static AtomicInteger sequence=new AtomicInteger(0);
    private static final String DEFAULT_ID_PRIFIX="COM";
    private static final String DEFAULT_UNIQUEMACHINE_KEY;

    static{

       DEFAULT_UNIQUEMACHINE_KEY=getDefaultUniqueMachineKey();


    }

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    public static String getUniqueSequence(){
        return getUniqueSequence(null, null);
    }

    public static String getUniqueSequence(String prefix,String uniqueMachineKey){
        return String.format("%s%s%s%s%s", getPrefix(prefix), getUniqueMachineKey(uniqueMachineKey), getTimeStamp(), getSequence(),getRandom());
    }


    private static String getPrefix(String prefix){
        if(StringUtils.isBlank(prefix)){
            return DEFAULT_ID_PRIFIX;
        }else{
            return StringUtils.getLengthStringByIndex(prefix,3,'0',true);
        }
    }

    private static String getUniqueMachineKey(String uniqueMachineKey){
        if(StringUtils.isBlank(uniqueMachineKey)){
            return DEFAULT_UNIQUEMACHINE_KEY;
        }else{
            return StringUtils.getLengthStringByIndex(uniqueMachineKey,6,'0',false);
        }
    }


    private static String getDefaultUniqueMachineKey(){
        String ip=null;
        try{
             ip= NetUtils.getLocalAddress().getHostAddress();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(StringUtils.isBlank(ip)){
            return StringUtils.getLengthStringByIndex(ip,6,'0',true);
        }
        StringBuilder builder=new StringBuilder();
        String[] ipes=ip.split("\\.");
        for(int i=2;i<ipes.length;i++){
            builder.append(StringUtils.getLengthStringByIndex(ipes[i],3,'0',false));
        }
        return builder.toString();

    }

    private static String getTimeStamp(){
        return DateFormatUtils.formatDate2Str(new Date(), DateFormatUtils.DatePattern.YYYYMMDDHHMMSSSSS);
    }

    private static String getSequence(){
        Integer sequenceNumber=sequence.incrementAndGet();
        String sequenceString=sequenceNumber.toString();
        return StringUtils.getLengthStringByIndex(sequenceString, 3, '0', false);
    }


    private static String getRandom(){
        String randomString=((Integer)new Random().nextInt(1000)).toString();
        return StringUtils.getLengthStringByIndex(randomString,3,'0',false);
    }


}



