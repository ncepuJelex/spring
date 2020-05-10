package com.jel.tech.choose;

import com.jel.tech.choose.model.OptionalPack;

import java.util.List;

/**
 * @author jelex
 * @date 2020-05-09:22:55
 * @description
 **/
public class ChooseFirstContext extends ChooseContextSupport<OptionalPack> {

    @Override
    public boolean chooseFirst() {
        return true;
    }

    @Override
    public OptionalPack doChoose(List<OptionalPack> list) {

        return list.get(0);
    }
}
