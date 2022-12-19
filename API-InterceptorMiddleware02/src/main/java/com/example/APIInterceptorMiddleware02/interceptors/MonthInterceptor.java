package com.example.APIInterceptorMiddleware02.interceptors;

import com.example.APIInterceptorMiddleware02.entities.MonthEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<MonthEntity> monthEntityList = new ArrayList<>(Arrays.asList(

            new MonthEntity(4, "April", "Aprile", "April"),
            new MonthEntity(1, "January", "Gennaio", "Januar"),
            new MonthEntity(2, "February", "Febbraio", "Februar"),
            new MonthEntity(5, "May", "Maggio", "Kann"),
            new MonthEntity(8, "August", "Agosto", "August"),
            new MonthEntity(6, "June", "Giugno", "Juni")
    ));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getHeader("/months") == null){

            System.out.println(HttpStatus.BAD_REQUEST);
            return false;
        }

        else if (monthEntityList.contains(request.getHeader("/months"))){

            System.out.println(request.getHeader("/months"));
        }

        else{

            monthEntityList.add(monthEntityList.size(), new MonthEntity(0, "nope", "nope", "nope"));
        }

        System.out.println(HttpStatus.OK);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
