package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc = new Scanner(System.in);
    private WiseSayingController wiseSayingController = new WiseSayingController();

    public void run() {

        System.out.println("==명언 SSG==");

        outer:
        while (true) {

            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Request rq = new Request(cmd);

            switch (rq.getPath()) {

                case "등록":

                    wiseSayingController.register();

                    break;

                case "목록":

                    wiseSayingController.printList();

                    break;

                case "삭제":

                    wiseSayingController.delete(rq);

                    break;

                case "수정":

                    wiseSayingController.change(rq);

                    break;

                case "종료":

                    break outer;

                default:

                    System.out.println("해당 명령어는 존재하지 않습니다.");

                    break;

            }

        }


    }



}
