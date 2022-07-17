package com.jung.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    private Scanner sc = new Scanner(System.in);

    public void change(Request rq) {

        int id = Integer.parseInt(rq.getQueryParamValue("id", "0"));

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(id);

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

    public void delete(Request rq) {

        int id = Integer.parseInt(rq.getQueryParamValue("id", "0"));

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(id);

        if (foundWiseSaying == null) {
            System.out.println("해당 id의 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingRepository.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", foundWiseSaying.getId());


    }

    public void printList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        List<WiseSaying> wiseSayingList = wiseSayingRepository.getWiseSayingList();

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }

    }

    public void register() {

        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());

    }

    public void searchById(Request rq) {

        if (rq.getQueryParamValue("id", "0") == "") {
            System.out.println("id를 입력해주세요.");
            return;
        }

        int id = Integer.parseInt(rq.getQueryParamValue("id", "0"));

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(id);

        if (foundWiseSaying == null) {
            System.out.println("찾는 번호의 명언은 존재하지 않습니다.");
        }
        else {
            System.out.printf("==%d번 명언==\n", foundWiseSaying.getId());
            System.out.printf("명언 : %s\n", foundWiseSaying.getContent());
            System.out.printf("작가 : %s\n", foundWiseSaying.getAuthor());
        }
    }

    public void searchByKeyword(Request rq) {

        String keyword = rq.getQueryParamValue("keyword", "0");

        if (keyword.equals("")) {
            System.out.println("찾는 keyword를 입력해주세요.");
        }

        List<WiseSaying> foundWiseSayingList = wiseSayingRepository.findByKeyword(keyword);

        if (foundWiseSayingList.size() == 0) {
            System.out.println("찾는 키워드의 명언은 존재하지 않습니다.");
            return;
        }

        for (WiseSaying wiseSaying : foundWiseSayingList) {
            System.out.printf("==%d번 명언==\n", wiseSaying.getId());
            System.out.printf("명언 : %s\n", wiseSaying.getContent());
            System.out.printf("작가 : %s\n", wiseSaying.getAuthor());
        }
    }

    public void searchByAuthor(Request rq) {

        String target = rq.getQueryParamValue("author", "0");

        if (target.equals("")) {
            System.out.println("찾는 작가를 입력해주세요.");
        }

        List<WiseSaying> foundWiseSayingList = wiseSayingRepository.findByAuthor(target);

        if (foundWiseSayingList.size() == 0) {
            System.out.println("찾는 작가의 명언은 존재하지 않습니다.");
            return;
        }

        for (WiseSaying wiseSaying : foundWiseSayingList) {
            System.out.printf("==%d번 명언==\n", wiseSaying.getId());
            System.out.printf("명언 : %s\n", wiseSaying.getContent());
            System.out.printf("작가 : %s\n", wiseSaying.getAuthor());
        }

    }

}
