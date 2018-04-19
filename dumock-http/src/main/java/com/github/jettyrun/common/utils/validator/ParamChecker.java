package com.github.jettyrun.common.utils.validator;

import com.github.jettyrun.common.utils.reflect.ReflectionUtils;
import com.github.jettyrun.common.utils.type.ObjectUtils;
import com.github.jettyrun.common.utils.type.StringUtils;
import java.lang.reflect.Field;


/**
 * Created by jetty on 18/2/12.
 */
public final class ParamChecker {

    private ParamChecker(){

    }

    public static void check(Object object) throws Exception{
        if(ObjectUtils.isEmpty(object)){
            throw new Exception(String.format("对象[%s]不能为空",object.getClass()));
        }
        for(Field field:ReflectionUtils.findAllField(object.getClass())){
            ReflectionUtils.makeAccessible(field);
            checkField(field, ReflectionUtils.getField(field, object));
        }
    }


    private static void checkField(Field field,Object o) throws Exception{
       checkNumber(field, o);
       checkBlack(field, o);
       checkEmpty(field, o);
       checkNull(field, o);
    }

    private static void checkBlack(Field field,Object object)throws Exception{
        NotBlack notBlack= field.getAnnotation(NotBlack.class);
        if(notBlack!=null){
            if(StringUtils.isBlank((String) object)){
                throw new Exception(String.format("参数[%s]不能为空",field.getName()));
            }
        }
    }

    private static void checkEmpty(Field field,Object object)throws Exception{
        NotEmpty notEmpty=field.getAnnotation(NotEmpty.class);
        if(notEmpty!=null){
            if(ObjectUtils.isEmpty(object)){
                throw new Exception(String.format("参数[%s]不能为空",field.getName()));
            }
        }
    }

    private static void checkNull(Field field,Object object)throws Exception{
        NotNull notNull=field.getAnnotation(NotNull.class);
        if(notNull!=null){
            if(object==null){
                throw new Exception(String.format("参数[%s]不能为null",field.getName()));
            }
        }
    }


    private static void checkNumber(Field field,Object object)throws Exception{
        Number num=field.getAnnotation(Number.class);
        if(num!=null){
            if(object instanceof Long){
                if(!StringUtils.isBlank(num.gt())&&(Long)object<Long.parseLong(num.gt())){
                    throw new Exception(String.format("参数[%s]的值应大于[%s]，而真实值为[%s]",field.getName(),num.gt(),object));
                }
                if(!StringUtils.isBlank(num.lt())&&(Long)object>Long.parseLong(num.lt())){
                    throw new Exception(String.format("参数[%s]的值应小于于[%s]，而真实值为[%s]",field.getName(),num.lt(),object));
                }
            }else if(object instanceof Double){
                if(!StringUtils.isBlank(num.gt())&&(Double)object<Double.parseDouble(num.gt())){
                    throw new Exception(String.format("参数[%s]的值应大于[%s]，而真实值为[%s]",field.getName(),num.gt(),object));
                }
                if(!StringUtils.isBlank(num.lt())&&(Double)object>Double.parseDouble(num.lt())){
                    throw new Exception(String.format("参数[%s]的值应小于于[%s]，而真实值为[%s]",field.getName(),num.lt(),object));
                }
            } else if(object instanceof Integer){
                if(!StringUtils.isBlank(num.gt())&&(Integer)object<Integer.parseInt(num.gt())){
                    throw new Exception(String.format("参数[%s]的值应大于[%s]，而真实值为[%s]",field.getName(),num.gt(),object));
                }
                if(!StringUtils.isBlank(num.lt())&&(Integer)object>Integer.parseInt(num.lt())){
                    throw new Exception(String.format("参数[%s]的值应小于于[%s]，而真实值为[%s]",field.getName(),num.lt(),object));
                }
            } else if(object instanceof Float){
                if(!StringUtils.isBlank(num.gt())&&(Float)object<Float.parseFloat(num.gt())){
                    throw new Exception(String.format("参数[%s]的值应大于[%s]，而真实值为[%s]",field.getName(),num.gt(),object));
                }
                if(!StringUtils.isBlank(num.lt())&&(Float)object>Float.parseFloat(num.lt())){
                    throw new Exception(String.format("参数[%s]的值应小于于[%s]，而真实值为[%s]",field.getName(),num.lt(),object));
                }
            } else if(object instanceof  Short){
                if(!StringUtils.isBlank(num.gt())&&(Short)object<Short.parseShort(num.gt())){
                    throw new Exception(String.format("参数[%s]的值应大于[%s]，而真实值为[%s]",field.getName(),num.gt(),object));
                }
                if(!StringUtils.isBlank(num.lt())&&(Short)object>Short.parseShort(num.lt())){
                    throw new Exception(String.format("参数[%s]的值应小于于[%s]，而真实值为[%s]",field.getName(),num.lt(),object));
                }
            }

        }

    }




}
