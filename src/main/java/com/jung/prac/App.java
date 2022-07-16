package com.jung.prac;

import java.util.Scanner;

public class App {

    public void run() {

        Scanner sc = new Scanner(System.in);
        /*== 명언 SSG ==
            명령) 종료*/
        System.out.println("==명언 SSG==");
        System.out.printf("명령) ");
        String cmd = sc.nextLine();

        outer:
        while (true) {

            switch (cmd) {

                case "종료":

                    break outer;

            }

        }


    }


}
