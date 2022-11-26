package com.digipay.usermanagement.controller;

import com.digipay.usermanagement.model.entity.*;
import com.digipay.usermanagement.repository.*;
import com.digipay.usermanagement.service.*;


import java.util.List;
import java.util.Scanner;

public  class UserController  {
    Scanner scanner = new Scanner(System.in);
    UserRepository userRepository =new UserRepository();
    BaseService<User> userService = new UserService(userRepository);

    RoleRepository roleRepository =new RoleRepository();
    BaseService<Role> roleService = new RoleService(roleRepository);
    User user=new User();
    Role role=new Role();

    public void userOperation() {

        Messages.userOpertaionMessage();
        int userOperationNumber = scanner.nextInt();

        if (userOperationNumber == 1) {
            System.out.println("Enter Username:");
            String username = scanner.next();
            System.out.println("Enter User national code:");
            String userNationalID = scanner.next();
            //
            System.out.println("Enter Role ID: ");
            roleList();
            Long userRoleId = scanner.nextLong();
            //
            user.setUsername(username);
            user.setNationalID(userNationalID);
            role.setRoleID(userRoleId);
            user.setRole(role);
            userService.create(user);
            //
        } else if (userOperationNumber == 2) {
            List<User> userList = userService.listAll(user);
            for (User userObject : userList) {
                System.out.printf(userObject.toString());
            }

        } else if (userOperationNumber == 3) {
            System.out.println("Enter User ID: ");
            Long userID = scanner.nextLong();
            System.out.println("Enter 'New' Username:");
            String username = scanner.next();
            System.out.println("Enter 'New' User national code:");
            String userNationalID = scanner.next();

            System.out.println("Enter 'New' Role ID: ");
            roleList();
            Long userRoleId = scanner.nextLong();

            user.setUserID(userID);
            user.setUsername(username);
            user.setNationalID(userNationalID);
            role.setRoleID(userRoleId);
            user.setRole(role);
            userService.update(user);


        } else if (userOperationNumber == 4) {
            System.out.println("Enter User ID: ");
            Long userID = scanner.nextLong();
            user.setUserID(userID);
            userService.delete(user);

        } else {
            System.out.println("invalid input!");
        }
    }
    public void roleList(){
        List<Role> roleList = roleService.listAll(role);
        for (Role roleid : roleList) {
            System.out.printf(roleid.toString());
        }
    }
}




