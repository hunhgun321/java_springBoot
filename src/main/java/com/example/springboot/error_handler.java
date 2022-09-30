package com.example.springboot;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.*; // For RequestDispatcher
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class error_handler implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        System.out.println("......Inside the error handler......");

        // get error status
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // TODO: log error details here

        // if (status != null) {
        // int statusCode = Integer.parseInt(status.toString());

        // // display specific error page
        // if (statusCode == HttpStatus.NOT_FOUND.value()) {
        // return "404";
        // } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        // return "500";
        // } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
        // return "403";
        // }
        // }

        // display generic error
        return "error1";
    }
}
