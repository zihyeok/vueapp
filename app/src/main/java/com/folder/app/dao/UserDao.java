package com.folder.app.dao;

import com.folder.app.dto.UserDTO;

import java.util.List;

public interface UserDao {

    public List<UserDTO> findAll();
    public int editById(UserDTO uDto);
    public int delete(int no);
    public int save(UserDTO uDto);


}
