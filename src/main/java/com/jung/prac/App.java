package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private int wiseSayingId = 0;
    private WiseSaying wiseSaying = new WiseSaying();
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {

        System.out.println("==명언 SSG==");

        outer:
        while (true) {

            System.out.printf("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {

                case "등록":

                    register();

                    break;

                case "종료":

                    break outer;

            }

        }


    }

    private void register() {

        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가 : ");
        String author = sc.nextLine();

        wiseSaying.setId(++wiseSayingId);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingList.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());

    }


}
