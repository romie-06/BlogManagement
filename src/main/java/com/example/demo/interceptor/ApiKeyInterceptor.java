package com.example.demo.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiKeyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader("X-api-key");
        if (apiKey.equals("valid_api_Key")) {
            return true;
        }

        if (apiKey == null || apiKey.isEmpty()) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "Missing Header: X-api-key");
            return false;
        }

        response.sendError(HttpStatus.UNAUTHORIZED.value(), "You are not allowed to access this.");
        return false;
    }
}
