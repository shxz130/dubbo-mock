package com.github.jettyrun.common.utils.collection;

import com.github.jettyrun.common.utils.type.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;

public abstract class CollectionUtils {

    /**
     * 是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 数组转换为List
     * @param source
     * @return
     */
    public static List arrayToList(Object source) {
        return Arrays.asList(ObjectUtils.toObjectArray(source));
    }

    /**
     * 将数组添加到collection中
     * @param array
     * @param collection
     * @param <E>
     */
    public static <E> void mergeArrayIntoCollection(Object array, Collection<E> collection) {
        Object[] arr = ObjectUtils.toObjectArray(array);
        for (Object elem : arr) {
            collection.add((E) elem);
        }
    }

    /**
     * 将properties的信息添加到map中
     * @param props
     * @param map
     * @param <K>
     * @param <V>
     */
    public static <K, V> void mergePropertiesIntoMap(Properties props, Map<K, V> map) {
        if (props != null) {
            for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
                String key = (String) en.nextElement();
                Object value = props.get(key);
                if (value == null) {
                    value = props.getProperty(key);
                }
                map.put((K) key, (V) value);
            }
        }
    }


    /**
     * List中是否含有element元素
     * @param list
     * @param element
     * @return
     */
    public static boolean contains(List list, Object element) {
        Iterator iterator=list.iterator();
        return contains(iterator,element);
    }


    /**
     * set中是否有元素
     * @param set
     * @param element
     * @return
     */
    public static boolean contains(Set set, Object element) {
        Iterator iterator=set.iterator();
        return contains(iterator,element);
    }


    /**
     * 判断
     * @param iterator
     * @param element
     * @return
     */
    private static boolean contains(Iterator<?> iterator, Object element) {
        if (iterator != null) {
            while (iterator.hasNext()) {
                Object candidate = iterator.next();
                if (ObjectUtils.nullSafeEquals(candidate, element)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * collecto中是否有element实例
     * @param collection
     * @param element
     * @return
     */
    public static boolean containsInstance(Collection<?> collection, Object element) {
        if (collection != null) {
            for (Object candidate : collection) {
                if (candidate.equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean containsAny(Collection<?> source, Collection<?> candidates) {
        if (isEmpty(source) || isEmpty(candidates)) {
            return false;
        }
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取两个容器中，第一个相同的对象
     * @param source
     * @param candidates
     * @param <E>
     * @return
     */
    public static <E> E findFirstMatch(Collection<?> source, Collection<E> candidates) {
        if (isEmpty(source) || isEmpty(candidates)) {
            return null;
        }
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return (E) candidate;
            }
        }
        return null;
    }


    /**
     * 获取set中最后一个元素
     * @param set
     * @param <T>
     * @return
     */
    public static <T> T lastElement(Set<T> set) {
        if (isEmpty(set)) {
            return null;
        }
        if (set instanceof SortedSet) {
            return ((SortedSet<T>) set).last();
        }

        Iterator<T> it = set.iterator();
        T last = null;
        while (it.hasNext()) {
            last = it.next();
        }
        return last;
    }

    /**
     * 获取list中的最后一个元素
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T lastElement(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }


    /**
     * 将map中的key，value用分隔符separator分开
     * @param map
     * @param separator
     * @return
     */
    public static List<String> join(Map<String, String> map, String separator) {
     if (map == null) {
        return null;
     }
     List<String> list = new ArrayList();
     if ((map == null) || (map.size() == 0)) {
       return list;
     }
     for (Map.Entry<String, String> entry : map.entrySet()) {
       String key = (String)entry.getKey();
       String value = (String)entry.getValue();
       if ((value == null) || (value.length() == 0)) {
         list.add(key);
       } else {
         list.add(key + separator + value);
       }
     }
     return list;
   }

    /**
     * 将list中的元素用separator拼接成一个String
     * @param list
     * @param separator
     * @return
     */
    public static String join(List<String> list, String separator) {
     StringBuilder sb = new StringBuilder();
     for (String ele : list) {
       if (sb.length() > 0) {
         sb.append(separator);
       }
      sb.append(ele);
     }
     return sb.toString();
   }

    /**
     * 判断map的属性是否一致
     * @param map1
     * @param map2
     * @return
     */
    public static boolean mapEquals(Map<?, ?> map1, Map<?, ?> map2) {
     if ((map1 == null) && (map2 == null)) {
       return true;
     }
     if ((map1 == null) || (map2 == null)) {
       return false;
    }
     if (map1.size() != map2.size()) {
       return false;
     }
     for (Map.Entry<?, ?> entry : map1.entrySet()) {
      Object key = entry.getKey();
      Object value1 = entry.getValue();
       Object value2 = map2.get(key);
       if (!ObjectUtils.objectEquals(value1, value2)) {
         return false;
       }
     }
     return true;
   }



}
