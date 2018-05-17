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
    @Test
    public void test03(){
       int sum=80;
       int five=50;
       int two=20;
       int one=10;
       int fivejiao=5;
       for(int a=0;a<=sum/five;a++){
           for(int b=0;b<=sum/two;b++){
              // if((sum-a*five)<0) break;
               for (int c=0;c<=sum/one;c++){
                   if((sum-(a*five+b*two+c*one))<0) break;
                   int d=(sum-(a*five+b*two+c*one))/5;
                   if(a*five+b*two+c*one+d*fivejiao==sum){
                       System.out.println("可能的找零方案:"+"5元"+a+"张,2元"+b+"张,1元"+c+"张,5角"+d+"张");
                   }
               }
           }
       }
    }

}
