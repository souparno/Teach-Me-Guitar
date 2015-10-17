package com.guitar;

import com.guitar.scale.MajorScale;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author bonnie
 */
public class App {

    static List<String> notes = new ArrayList<>();
    static String note;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean iterate = true;
        int choice;
        do {
            System.out.println("1. search a Scales by Notes");
            System.out.println("2. Get a Scale Notes");
            System.out.println("3. Get the chord Progression");
            System.out.println("4. to quit");
            System.out.println("Input your choices");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    App.showScales();
                    break;
                case 2:
                    App.showScaleNotes();
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    iterate = false;
                    break;
            }
        } while (iterate);
    }

    private static void showScales() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter a Note, <enter 'q' to stop>");
            note = br.readLine();
            if (note.equalsIgnoreCase("q")) {
                break;
            }
            notes.add(note);
        }

        MajorScale majorscale = new MajorScale();
        List<String> scales = majorscale.find(notes);
        System.out.print("The notes belongs to the scale/s :- ");
        for (String scale : scales) {
            System.out.print(scale + ", ");
        }
        System.out.println("");
    }

    private static void showScaleNotes() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the root note");
        String root_note = br.readLine();
        MajorScale majorscale = new MajorScale();
        String scale_notes[] = majorscale.get(root_note);
        System.out.print("The notes for the " + root_note + " scale is :- ");
        for (String n : scale_notes) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }

}
