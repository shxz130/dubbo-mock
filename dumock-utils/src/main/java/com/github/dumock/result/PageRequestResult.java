package com.github.dumock.result;

import lombok.*;

/**
 * Created by jetty on 18/6/29.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestResult<T> extends AbstractResquestResult{

    private T data;

    private Page page;

}
