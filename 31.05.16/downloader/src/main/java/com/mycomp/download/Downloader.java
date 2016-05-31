package com.mycomp.download;

import java.util.Scanner;

public class Downloader {
    public static void main(String[] args) {
        System.out.println("Enter link starts with = 'https://pp.vk.me/' and ends with = '.jpg' and space");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.endsWith(".jpg ")&& s.startsWith("https://pp.vk.me/")) {
                System.out.println("Loading started!");
                Thread t = new Thread(new DownStream(s));
                t.start();
            } else System.out.println("Not valid link!");
        }
    }

}
