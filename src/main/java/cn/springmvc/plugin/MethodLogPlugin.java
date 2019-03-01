package cn.springmvc.plugin;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MethodLogPlugin implements MethodBeforeAdvice {

    public MethodLogPlugin(){
        System.out.println("===========>>>初始化 MethodLogPlugin");
    }


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("=======>>> 开始执行");
            System.out.println(String.format("The calss %s invoked method %s",method.getDeclaringClass().getName()+"():",method.getName()));
    }


}
