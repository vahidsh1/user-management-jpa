package com.digipay.usermanagement.controller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Messages.welcomeMessage();
        while (true) {
            Messages.operation();

            int operationNumber = scanner.nextInt();
            if (operationNumber == 1) {
                UserController userController = new UserController();
                userController.userOperation();

            } else if (operationNumber == 2) {
                RoleController roleController = new RoleController();
                roleController.roleOperation();

            } else if (operationNumber == 3) {
                PermissionController permissionController = new PermissionController();
                permissionController.permissionOperation();

            } else {
                System.err.println("invalid input!");
            }
        }
    }
}
