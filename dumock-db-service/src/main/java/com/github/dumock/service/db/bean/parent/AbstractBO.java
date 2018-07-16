package com.github.dumock.service.db.bean.parent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by jetty on 18/7/16.
 */
@ToString(callSuper = true)
@NoArgsConstructor
@Data
public class AbstractBO {
    private Long id;
    private Date createTime;
    private Date updateTime;
}
