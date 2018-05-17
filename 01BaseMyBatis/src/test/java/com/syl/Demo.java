package com.syl;

import org.junit.Test;

public class Demo {
   @Test
    public void test01(){

       for (int x=0;x<=50;x++){
           int y=50-x;
           if (2*x+4*y==120){
               System.out.println("鸡的数量:"+x);
               System.out.println("兔的数量:"+y);
           }
       }
   }
    @Test
    public void test02(){
        for (int i=1000;i<2000;i++){
            if (i%5==1&&i%7==2&&i%8==3){
                System.out.println("i="+i);
            }
        }
    }


}
