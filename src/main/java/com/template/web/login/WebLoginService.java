package com.template.web.login;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WebLoginService {

    WebLoginDao webLoginDao;

    public WebLoginUser findOne(String username) throws Exception {
        WebLoginUser webLoginUser = webLoginDao.findById(username).get(0);

        if (webLoginUser == null) {
            throw new Exception();
        }
        return webLoginUser;
    }
}
