package com.ll.exam;

import java.util.Scanner;

public class WellKnownController {
    WellKnownService wellKnownService;
    Scanner sc;
    public WellKnownController(Scanner sc) {
        wellKnownService = new WellKnownService();
        this.sc = sc;
    }

    public void write() {
        System.out.print("명언 : ");
        String wellKnownSaying = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        WellKnown wellKnown = wellKnownService.write(wellKnownSaying, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wellKnown.id);
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = wellKnownService.wellKnowns.size()-1; i >= 0; i--) {
            WellKnown wellKnown = wellKnownService.wellKnowns.get(i);
            System.out.printf("%d / %s / %s\n", wellKnown.id, wellKnown.author, wellKnown.wellKnownSaying);
        }
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParamValue("id",0);
        if(paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WellKnown foundWellKnown = wellKnownService.findById(paramId);
        if(foundWellKnown == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }
        wellKnownService.remove(paramId);
        System.out.printf("%d번 명언이 삭제되었습니다\n", paramId);
    }

    public void modify(Rq rq) {
        int paramId = rq.getIntParamValue("id",0);
        if(paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WellKnown foundWellKnown = wellKnownService.findById(paramId);
        if(foundWellKnown == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }
        System.out.printf("명언(기존) : %s\n",foundWellKnown.wellKnownSaying);
        System.out.print("명언 : ");
        String newWellKnownSaying = sc.nextLine().trim();
        System.out.printf("작가(기존) : %s\n", foundWellKnown.author);
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine().trim();
        wellKnownService.modify(paramId, newWellKnownSaying, newAuthor);
    }

}
