package com.github.dumock.result;

import lombok.*;

import java.io.Serializable;

/**
 * Created by jetty on 18/6/29.
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbstractResquestResult implements Serializable{

    protected String code;


    protected String message;
}
