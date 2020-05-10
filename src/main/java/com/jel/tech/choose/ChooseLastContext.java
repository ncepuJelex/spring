package com.jel.tech.choose;

import com.jel.tech.choose.model.OptionalPack;

import java.util.List;

/**
 * @author jelex
 * @date 2020-05-09:22:57
 * @description
 **/
public class ChooseLastContext extends ChooseContextSupport<OptionalPack> {

    @Override
    public boolean chooseLast() {
        return true;
    }

    @Override
    public OptionalPack doChoose(List<OptionalPack> list) {

        return list.get(list.size() - 1);
    }
}
