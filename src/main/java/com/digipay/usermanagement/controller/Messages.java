package com.digipay.usermanagement.controller;

class Messages {
    public static void welcomeMessage() {
        System.out.println("Welcome to User Management System!");
        System.out.println("Select main sector:");
    }

    public static void operation(){
        System.out.println("1-User operation\n" +
                "2-Role operation\n" +
                "3-Permission operation");
    }

    public static void userOpertaionMessage(){
        System.out.println("1-Create user\n" +
                    "2-List all users\n" +
                    "3-Update a user\n" +
                    "4-Delete a user");
    }
    public static void roleOperationMessage(){
        System.out.println("1-Create role\n" +
                "2-List all roles\n" +
                "3-Update a role\n" +
                "4-Delete a role");
    }
    public static void permissionOperationMessage(){
        System.out.println("1-Create permission\n" +
                "2-List all permissions\n" +
                "3-Update a permission\n" +
                "4-Delete a permission");
    }

    private Messages() {
    }
}
