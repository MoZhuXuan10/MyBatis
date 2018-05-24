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
    @Test
    public void test04(){
        long begin=System.currentTimeMillis();
        for(int i=0;i<=1000000;i++){
            int m=i%10;
            if(m!=0&&m!=1&&m!=5&&m!=6){continue;}
            if((i*i)%10==i||(i*i)%100==i||(i*i)%1000==i||(i*i)%10000==i||(i*i)%100000==i||(i*i)%100000==i){
                System.out.println("i:"+i+",i的平方:"+i*i);
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("共用时:"+(end-begin));
    }

    /**
     * 给定指定的元素,判断是否为闰年
     *
     * 除以4=0,除以400=0,除以100!=0
     */
    @Test
    public void test05(){
        //定义年数
        int year=2000;
        boolean flag=year%4==0&&year%100!=0||year%400==0;//不建议使用,可读性差
        System.out.println(flag);
    }
    @Test
    public void test06(){
        //定义年数
        int year=2000;
        boolean flag=false;//假设修正法
        if(year%4==0) flag=true;
        if(year%100==0) flag=false;
        if(year%400==0) flag=true;
        System.out.println(flag);
    }

    /**
     * 求三个数字的最大值
     */
    @Test
    public void test07(){
       int a=2018;
       int b=20;
       int c=18;
       //假设最大值是a
        int max=a;
        if(b>a) max=b;
        if(c>b) max=c;
        System.out.println(max);
    }
    /**
     * 常数变易法
     */
    @Test
    public void test08(){
        for(int i=0;i<5;i++){//几行
            for(int j=0;j<9-i;j++){//空格
                System.out.print(" ");
            }
            for(int k=0;k<i+1;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
