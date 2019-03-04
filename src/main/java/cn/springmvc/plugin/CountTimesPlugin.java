package cn.springmvc.plugin;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

public class CountTimesPlugin implements MethodBeforeAdvice {

    public CountTimesPlugin() {
        System.out.println("===========>>>初始化 CountTimesPlugin");
    }

    private int count;

    protected void count() {
        count++;
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (method.getDeclaringClass().isAnnotationPresent(Controller.class) || method.getDeclaringClass().isAnnotationPresent(Service.class)) {
            count();
            System.out.println("=======>>> 开始计数");
            System.out.println(String.format("The method %s invoked times %s", method.getName() + "():", count));
        }
    }

}
