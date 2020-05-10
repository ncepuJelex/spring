package com.jel.tech.choose;

import java.util.List;

/**
 * @author jelex
 * @date 2020-05-09:22:50
 * @description
 **/
public interface ChooseContext<T> {

    /**
     * 是否第一个
     * @return
     */
    boolean chooseFirst();

    /**
     * 是否最后一个
     * @return
     */
    boolean chooseLast();

    /**
     * 选择
     * @param list
     * @return
     */
    T choose(List<T> list);
}
