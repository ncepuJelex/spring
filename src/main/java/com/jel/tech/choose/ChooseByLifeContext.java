package com.jel.tech.choose;

import com.jel.tech.choose.model.OptionalPack;

import java.util.Comparator;
import java.util.List;

/**
 * @author jelex
 * @date 2020-05-09:22:58
 * @description
 **/
public class ChooseByLifeContext extends ChooseContextSupport<OptionalPack> {

    @Override
    protected OptionalPack doChoose(List<OptionalPack> list) {

        list.sort(Comparator.comparing(OptionalPack::getBatteryLife));
        return list.get(0);
    }
}
