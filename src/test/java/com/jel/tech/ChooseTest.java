package com.jel.tech;

import com.jel.tech.choose.*;
import com.jel.tech.choose.model.OptionalPack;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jelex
 * @date 2020-05-09:23:00
 * @description
 **/
public class ChooseTest {

    @Test
    public void fun() {

        List<OptionalPack> list = new ArrayList<>(3);

        OptionalPack x = new OptionalPack();

        x.setId(1);
        x.setBatteryLife("500");
        x.setFeatureCode("OPPAK05");

        list.add(x);

        x = new OptionalPack();

        x.setId(2);
        x.setBatteryLife("300");
        x.setFeatureCode("OPPAK04");

        list.add(x);

        x = new OptionalPack();

        x.setId(3);
        x.setBatteryLife("400");
        x.setFeatureCode("OPPAK12");

        list.add(x);

        ChooseContext<OptionalPack> context = new ChooseFirstContext();

        OptionalPack choose = context.choose(list);

        System.out.println(choose);

        context = new ChooseLastContext();

        OptionalPack choose2 = context.choose(list);

        System.out.println(choose2);

        context = new ChooseByLifeContext();

        OptionalPack choose3 = context.choose(list);

        System.out.println(choose3);

        context = new ChooseContextSupport<OptionalPack>() {

            @Override
            protected OptionalPack doChoose(List<OptionalPack> list) {

                int randomIndex = new Random().nextInt(list.size());

                System.out.println("randomIndex: " + randomIndex);

                return list.get(randomIndex);
            }
        };

        OptionalPack choose4 = context.choose(list);

        System.out.println(choose4);
    }
}
