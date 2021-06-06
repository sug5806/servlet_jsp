package next.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    public static Map<String, Controller> controllerMap = new HashMap<>();

    static {
        controllerMap.put("/users", new ListUserController());
        controllerMap.put("/users/create", new CreateUserController());
        controllerMap.put("/users/login", new LoginController());
        controllerMap.put("/users/logout", new LogoutController());
        controllerMap.put("/users/form", new ForwardController("/user/form.jsp"));
        controllerMap.put("/users/loginForm", new ForwardController("/user/login.jsp"));
        controllerMap.put("/", new ForwardController("index.jsp"));
    }
}
