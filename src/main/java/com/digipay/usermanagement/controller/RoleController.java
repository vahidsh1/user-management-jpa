package com.digipay.usermanagement.controller;

import com.digipay.usermanagement.model.entity.*;
import com.digipay.usermanagement.repository.*;
import com.digipay.usermanagement.service.*;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RoleController {
    Scanner scanner = new Scanner(System.in);
    RoleRepository roleRepository = new RoleRepository();
    BaseService<Role> roleService = new RoleService(roleRepository);
    PermissionRepository permissionRepository = new PermissionRepository();
    BaseService<Permission> permissionService = new PermissionService(permissionRepository);

    Role role = new Role();
    Permission permission = new Permission();
    Set<Permission> permissionSet = new HashSet<Permission>();


    public void roleOperation() {

        Messages.roleOperationMessage();
        int roleOperationNumber = scanner.nextInt();

        if (roleOperationNumber == 1) {
            System.out.println("Enter Role title:");
            String roleTitle = scanner.next();
            //
            System.out.println("Enter Permission ID: ");
            permissionDisplay();
            Long permissionID = scanner.nextLong();
            //
            permission.setPermissionID(permissionID);
            permissionSet.add(permission);
            role.setPermissions(permissionSet);
            role.setRoleTitle(roleTitle);
            roleService.create(role);

        } else if (roleOperationNumber == 2) {
            List<Role> roleList = roleService.listAll(role);
            for (Role roleObject : roleList) {
                System.out.println(roleObject.toString());
            }

        } else if (roleOperationNumber == 3) {
            System.out.println("Enter Role ID: ");
            Long roleID = scanner.nextLong();

            System.out.println("Enter 'New' Role title:");
            String roleTitle = scanner.next();

            role.setRoleTitle(roleTitle);
            role.setRoleID(roleID);
            roleService.update(role);

        } else if (roleOperationNumber == 4) {
            System.out.println("Enter Role ID: ");
            Long roleID = scanner.nextLong();
            role.setRoleID(roleID);
            roleService.delete(role);
        }
    }
    public void permissionDisplay(){
        List<Permission> permissionList = permissionService.listAll(permission);
        for (Permission x : permissionList) {
            System.out.println(x.toString());
        }
    }
}
