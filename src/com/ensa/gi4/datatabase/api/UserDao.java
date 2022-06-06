package com.ensa.gi4.datatabase.api;
import java.util.List;

import com.ensa.gi4.modele.*;

public interface UserDao {
  User findOneUser(String name, String password);
  List<User> finAllUsers();
  String getRole(String name);
}