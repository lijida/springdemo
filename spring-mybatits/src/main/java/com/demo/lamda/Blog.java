package com.demo.lamda;

import lombok.Data;

@Data
public class Blog {
    String name;
    @FunctionalInterface
    interface test {
        public void run(String string);
    }
    public static void main(String[] args) {
        System.out.println("lambda");
        test t1 = new test() {
            @Override
            public void run(String string) {
                System.out.println("匿名内部类创建实现类对象" + string);
            }
        };
        test t2 = (string) -> {
            System.out.println("lambda创建实现类对象" + string);
        };

        Blog blog=new Blog();


        Thread thread= new Thread(()->{
            System.out.println("启动线程");
        });

        thread.start();
    }

}
