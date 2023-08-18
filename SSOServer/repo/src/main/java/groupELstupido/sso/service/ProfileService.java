package groupELstupido.sso.service;

import groupELstupido.sso.dao.UserDao;
import groupELstupido.sso.request.UpdateUserImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    UserDao userDao;

    public boolean updateUserImage(UpdateUserImageRequest request) {
        return userDao.updateUserImage(request.getUsername(), request.getImageData(), request.getImageIdentifier());
    }
}
