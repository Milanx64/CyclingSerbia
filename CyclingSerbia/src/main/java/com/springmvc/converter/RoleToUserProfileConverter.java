package com.springmvc.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.model.UserProfile;
import com.springmvc.service.UserProfileService;

@Component
public class RoleToUserProfileConverter  implements Converter<Object, UserProfile>{

	@Autowired
    UserProfileService userProfileService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findById(id);
        //logger.info("Profile : {}",profile);
        return profile;
    }

}
