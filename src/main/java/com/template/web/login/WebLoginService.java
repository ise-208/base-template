package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebLoginService {

    @Autowired
    WebLoginDao webLoginDao;

    public WebUser findOne(String id) throws Exception {
        WebUser webUser = webLoginDao.findById(id).get(0);

        if (webUser == null) {
            throw new Exception();
        }
        return webUser;
    }
}
