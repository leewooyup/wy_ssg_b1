package com.ll.exam;

import java.util.Scanner;


public class App {
    WellKnownController wellKnownController;
    Scanner sc;

    public App() {
        sc = new Scanner(System.in);
        wellKnownController = new WellKnownController(sc);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch(rq.getPath()) {
                case "등록":
                    wellKnownController.write();
                    break;
                case "목록":
                    wellKnownController.list();
                    break;
                case "삭제":
                    wellKnownController.remove(rq);
                    break;
                case "수정":
                    wellKnownController.modify(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}
