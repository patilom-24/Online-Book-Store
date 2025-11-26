package com.om.service;

import jakarta.servlet.http.HttpSession;

import com.om.model.StoreException;
import com.om.model.User;
import com.om.model.UserRole;

public interface UserService {

    public User login(UserRole role, String email, String password, HttpSession session) throws StoreException;

    public String register(UserRole role, User user) throws StoreException;

    public boolean isLoggedIn(UserRole role, HttpSession session);

    public boolean logout(HttpSession session);

}
