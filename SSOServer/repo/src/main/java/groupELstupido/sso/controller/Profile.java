package groupELstupido.sso.controller;

import groupELstupido.sso.domain.model.UserDisplay;
import groupELstupido.sso.request.UpdateUserImageRequest;
import groupELstupido.sso.service.ProfileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@Controller
@RequestMapping("/profile")
public class Profile {
    @Autowired
    ProfileService profileService;
    @PostMapping("/updateImage")
    @ResponseBody
    public void updateProfilePicture (MultipartHttpServletRequest request,  HttpServletResponse response) {
        System.out.println("Update Image URI Triggered");

        MultipartFile multipartFile = request.getFile("profileImage");
        UserDisplay userDisplay = (UserDisplay) request.getSession(false).getAttribute("userDisplay");

        String name;
        byte [] imageData;

        if (multipartFile == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        try {
            imageData = multipartFile.getBytes();
            name = multipartFile.getOriginalFilename();
        } catch (IOException e) {
            System.out.println(e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        UpdateUserImageRequest updateUserImageRequest = new UpdateUserImageRequest(userDisplay.getUsername(), imageData, name);

        if (profileService.updateUserImage(updateUserImageRequest)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
