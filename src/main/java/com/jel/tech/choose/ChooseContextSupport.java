package com.jel.tech.choose;

import java.util.List;

/**
 * @author jelex
 * @date 2020-05-09:23:07
 * @description
 **/
public abstract class ChooseContextSupport<T> implements ChooseContext<T> {

    @Override
    public boolean chooseFirst() {
        return false;
    }

    @Override
    public boolean chooseLast() {
        return false;
    }

    @Override
    public T choose(List<T> list) {

        if (list == null || list.isEmpty()) {
            return null;
        }
        return doChoose(list);
    }

    /**
     * 具体选择策略
     * @param list
     * @return
     */
    protected abstract T doChoose(List<T> list);
}
