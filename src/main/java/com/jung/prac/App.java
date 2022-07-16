package com.jung.prac;

import java.util.Scanner;

public class App {

    private int wiseSayingId = 0;
    WiseSaying wiseSaying = new WiseSaying();

    public void run() {

        Scanner sc = new Scanner(System.in);

        System.out.println("==명언 SSG==");
        System.out.printf("명령) ");
        String cmd = sc.nextLine();

        outer:
        while (true) {

            switch (cmd) {

                /*
                == 명언 SSG ==
                명령) 등록
                명언 : 현재를 사랑하라.
                작가 : 작자미상
                명령) 종료
                 */
                case "등록":

                    register();

                    break;

                case "종료":

                    break outer;

            }

        }


    }

    private void register() {


    }


}
