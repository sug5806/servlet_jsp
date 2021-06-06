package next.controller;

import java.util.HashMap;
import java.util.Map;

public class ForwardController {
    private static Map<String, String> forwardMap = new HashMap<>();

    static {
        forwardMap.put("/users/form", "/user/form.jsp");
    }

    public static boolean isForwardUrl(String url) {
        String path = forwardMap.get(url);

        return path != null;
    }

    public static String getForwardPath(String url) {
        return forwardMap.get(url);
    }
}
