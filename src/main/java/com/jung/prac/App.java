package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private int wiseSayingId = 0;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {

        System.out.println("==명언 SSG==");

        outer:
        while (true) {

            System.out.printf("명령) ");
            String cmd = sc.nextLine();
            Request rq = new Request(cmd);

            switch (rq.getPath()) {

                case "등록":

                    register();

                    break;

                case "목록":

                    printList();

                    break;

                case "삭제":

                    delete(rq);

                    break;

                case "수정":

                    change(rq);

                    break;

                case "종료":

                    break outer;

            }

        }


    }

    private void change(Request rq) {

        /*명령) 수정?id=2
명언(기존) : 과거에 집착하지 마라.
명언 : 현재와 자신을 사랑하라.
작가(기존) : 작자미상
작가 : 홍길동*/



        int id = Integer.parseInt(rq.getQueryParamValue("id", "0"));

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = null;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        if (foundWiseSaying == null) {
            System.out.println("해당 id의 명언은 존재하지 않습니다.");
            return;
        }

        System.out.printf("명언(기존) : %s\n", foundWiseSaying.getContent());
        System.out.printf("명언 :");

        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", foundWiseSaying.getAuthor());
        System.out.printf("작가 : ");

        String author = sc.nextLine();

        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", foundWiseSaying.getId());

    }

    private void delete(Request rq) {

        int id = Integer.parseInt(rq.getQueryParamValue("id", "0"));

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = null;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        if (foundWiseSaying == null) {
            System.out.println("해당 id의 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingList.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", foundWiseSaying.getId());


    }

    private void printList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }

    }

    private void register() {

        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.setId(++wiseSayingId);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingList.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());

    }


}
