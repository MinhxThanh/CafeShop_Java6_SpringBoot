package edu.home.interceptor;

import edu.home.service.CategoriesInProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @Autowired
    private CategoriesInProductService categoriesInProductService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView){
        request.setAttribute("categoriesInterceptor", categoriesInProductService.findAll());
    }
}
