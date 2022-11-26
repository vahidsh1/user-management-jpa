package com.digipay.usermanagement.controller;

import com.digipay.usermanagement.model.entity.*;
import com.digipay.usermanagement.repository.*;
import com.digipay.usermanagement.service.*;

import java.util.List;
import java.util.Scanner;

public class PermissionController {
    Scanner scanner = new Scanner(System.in);

    PermissionRepository permissionRepository = new PermissionRepository();
    BaseService<Permission> permissionService = new PermissionService(permissionRepository);
    Permission permission = new Permission();

    public void permissionOperation() {

        Messages.permissionOperationMessage();
        int permissionOperationNumber = scanner.nextInt();

        if (permissionOperationNumber == 1) {
            System.out.println("Enter Permission title:");
            String permissionTitle = scanner.next();
            permission.setPermissionTitle(permissionTitle);
            permissionService.create(permission);

        } else if (permissionOperationNumber == 2) {
            List<Permission> permissionList = permissionService.listAll(permission);
            for (Permission permissionId : permissionList) {
                System.out.printf(permissionId.toString());
            }

        } else if (permissionOperationNumber == 3) {
            System.out.println("Enter Permission ID: ");
            Long permissionID = scanner.nextLong();

            System.out.println("Enter New Permission title:");
            String permissionTitle = scanner.next();
            permission.setPermissionTitle(permissionTitle);
            permission.setPermissionID(permissionID);
            permissionService.update(permission);

        } else if (permissionOperationNumber == 4) {
            System.out.println("Enter Permission ID: ");
            Long permissionID = scanner.nextLong();
            permission.setPermissionID(permissionID);
            permissionService.delete(permission);

        } else {
            System.out.println("invalid input!");
        }

    }

}

