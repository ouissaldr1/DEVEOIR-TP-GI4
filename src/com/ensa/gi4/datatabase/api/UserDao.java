package com.ensa.gi4.datatabase.api;
import java.util.List;

import com.ensa.gi4.modele.*;

public interface UserDao {
  User getUser(String name);
  User findOneUser(String name, String password);
  List<User> finAllUsers();
  String getRole(String name);
  void allouerMateriel(String code, String duree);
  Boolean rendreMateriel(int id);

}
