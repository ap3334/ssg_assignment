package com.jung.prac;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private int wiseSayingId = 0;
    private List<WiseSaying> wiseSayingList = new ArrayList<>();

    public int getWiseSayingId() {
        return wiseSayingId;
    }

    public void setWiseSayingId(int wiseSayingId) {
        this.wiseSayingId = wiseSayingId;
    }

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingList;
    }

    public void setWiseSayingList(List<WiseSaying> wiseSayingList) {
        this.wiseSayingList = wiseSayingList;
    }

    public int getSizeWiseSayingList() {
        return wiseSayingList.size();
    }

    public WiseSaying findById(int id) {

        WiseSaying foundWiseSaying = null;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        return foundWiseSaying;

    }

    public void remove(WiseSaying foundWiseSaying) {

        wiseSayingList.remove(foundWiseSaying);

    }

    public void save(WiseSaying wiseSaying) {

        wiseSaying.setId(++wiseSayingId);
        wiseSayingList.add(wiseSaying);

    }
}
