package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class HgsilPrisoner implements Prisoner{
    private int totalPerson;
    private int mBeanCount;
    private Manager manager;
    @Override
    public String getName() {   return "杨瀚之2015211518"; }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalPerson = totalPerson ;
        this.manager = manager ;
        this.mBeanCount = totalCount;
    }

    @Override
    public int take(int index, int last) {
        /*Class c1 = manager.getClass();
        List<Prisoner> prisoners = null;        //保存拿出来的所有人
        HashMap<Prisoner,Integer> personHold = null ;      //保存每个人拿出来的豆子数
        try {
            Field persons = c1.getDeclaredField("mPrisoners");
            persons.setAccessible(true);                    //提高效率
            prisoners = (List<Prisoner>) persons.get(manager);
            Field mHold = c1.getDeclaredField("mTempHold");
            mHold.setAccessible(true);
            personHold =  (HashMap<Prisoner, Integer>) mHold.get(manager);

        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (IllegalAccessException i){
            i.printStackTrace();
        }*/


        return 0;
    }

    @Override
    public void result(boolean survived) {

        if (!survived) {
            Class c1 = manager.getClass();
            HashMap<Prisoner,Integer> mScore = null;

            try {
                Field f1 = c1.getDeclaredField("mScore");
                f1.setAccessible(true);
                mScore = (HashMap<Prisoner, Integer>) f1.get(manager);
            }catch (NoSuchFieldException e) {
                e.printStackTrace();
            }catch (IllegalAccessException i){
                i.printStackTrace();
            }
            int n = mScore.get(this);
            mScore.replace(this,n+1);
        }
    }
}
