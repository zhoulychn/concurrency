package com.zhoulychn.singleton;

public class EnumSingleton {

    private EnumSingleton(){
    }

    //延迟加载
    private enum EnumHolder{
        INSTANCE;
        private static  EnumSingleton instance=null;

        private EnumSingleton getInstance(){
            instance=new EnumSingleton();
            return instance;
        }
    }

    //懒加载
    public static EnumSingleton  getInstance(){
        return EnumHolder.instance;
    }
}
