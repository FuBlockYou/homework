package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;
import org.geektimes.web.mvc.controller.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("")
public class RegisterController implements PageController {
    private UserService userService = new UserServiceImpl();
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phone");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();

        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setPassword(password);

        boolean register = userService.register(user);
        if (!register){
           return "index.jsp";
        }else {
            return "login-form.jsp";
        }


    }


}
