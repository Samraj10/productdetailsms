package com.infy.pr.productdetailsms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.pr.productdetailsms.model.GmailUser;
import com.infy.pr.productdetailsms.model.User;
import com.infy.pr.productdetailsms.model.YahooUser;
import com.infy.pr.productdetailsms.repo.GmailRepository;
import com.infy.pr.productdetailsms.repo.YahooRepository;

@Service
public class UserService {
    @Autowired
    private GmailRepository gmailUserRepository;

    @Autowired
    private YahooRepository yahooUserRepository;
    
    
    public void processUser(User user) {
        if (user.getEmail().endsWith("@gmail.com")) {
            GmailUser gmailUser = new GmailUser();
            gmailUser.setName(user.getName());
            gmailUser.setEmail(user.getEmail());
            gmailUserRepository.save(gmailUser);
        } else if (user.getEmail().endsWith("@yahoo.com")) {
            YahooUser yahooUser = new YahooUser();
            yahooUser.setName(user.getName());
            yahooUser.setEmail(user.getEmail());
            yahooUserRepository.save(yahooUser);
        } else {
            // Handle other cases or throw an exception
            throw new IllegalArgumentException("Unsupported email domain");
        }
    }
}

