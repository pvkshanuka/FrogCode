package main;

import java.util.Scanner;

public class FrogCode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        String resp = "";
        while (bool) {
            System.out.println("Do you want to jump frog by time or distance?");
            System.out.println("If time type 1 & enter.");
            System.out.println("If distance type 2 & enter.");

            resp = scanner.nextLine();
            if (resp.equals("1")) {
                jumpOnTime(scanner);
                bool = false;
            } else if (resp.equals("2")) {
                jumbOnDistance(scanner);
                bool = false;
            } else {
                System.out.println("Invalid Input.\n");
            }
        }
    }

    private static void jumbOnDistance(Scanner scanner) {

        boolean b = true;

        String distanceString = "";

        int time = 0;
        int distance = 0;
        int distanceJumped = 0;

        while (b) {

            System.out.println("Please enter distance(meters) to jump(in desimal number).");

            distanceString = scanner.nextLine();

            if (isInt(distanceString)) {
                distance = Integer.parseInt(distanceString);
                b = false;
            } else {
                System.out.println("Invalid distance..\n");
            }

        }

        while (distance != 0) {

            if (distance >= 5) {
                distance = distance - 5;
                time++;

                if (distance >= 3) {
                    distance = distance - 3;
                    time = time + 2;

                    if (distance >= 1) {
                        distance--;
                        time = time + 5;

                        distanceJumped = Integer.parseInt(distanceString) - distance;

                    } else {
                        distanceJumped = Integer.parseInt(distanceString) - distance;
                        distance = 0;
                    }

                } else {
                    distanceJumped = Integer.parseInt(distanceString) - distance;
                    distance = 0;
                }

            } else {
                distanceJumped = Integer.parseInt(distanceString) - distance;
                distance = 0;
            }

        }

        System.out.println("\nFrog Jhone Jumped " + distanceJumped + "m in " + time + "seconds;");

    }

    private static void jumpOnTime(Scanner scanner) {

        boolean b = true;

        String timeString = "";
        int time = 0;
        int distance = 0;

        while (b) {

            System.out.println("Please enter time(seconds) to jump(in desimal number).");

            timeString = scanner.nextLine();

            if (isInt(timeString)) {
                time = Integer.parseInt(timeString);
                b = false;
            } else {
                System.out.println("Invalid time..\n");
            }

        }

        while (time >= 0) {

            distance = distance + 5;
            if (time >= 1) {
                time--;
                distance = distance + 3;

                if (time >= 2) {
                    time = time - 2;
                    distance++;

                    if (time >= 5) {
                        time = time - 5;
                    } else {
                        time = -1;
                    }

                } else {
                    time = -1;
                }

            } else {
                time = -1;
            }

        }

        System.out.println("\nFrog Jhone Jumped " + distance + "m in " + timeString + "seconds;");

    }

    private static boolean isInt(String timeString) {

        try {
            Integer.parseInt(timeString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
