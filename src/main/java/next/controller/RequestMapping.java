package next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    public Map<String, Controller> controllerMap = new HashMap<>();

    void initMapping() {
        controllerMap.put("/users", new ListUserController());
        controllerMap.put("/users/create", new CreateUserController());
        controllerMap.put("/users/login", new LoginController());
        controllerMap.put("/users/logout", new LogoutController());
        controllerMap.put("/users/form", new ForwardController("/user/form.jsp"));
        controllerMap.put("/users/loginForm", new ForwardController("/user/login.jsp"));
        controllerMap.put("/", new ForwardController("index.jsp"));

        logger.info("RequestMapping Init!");
    }

    public Controller findController(String url) {
        return controllerMap.get(url);
    }

    void put(String url, Controller controller) {
        controllerMap.put(url, controller);
    }


}
