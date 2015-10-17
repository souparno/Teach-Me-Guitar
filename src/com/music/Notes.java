package com.music;

/**
 *
 * @author bonnie
 */
public class Notes {

    private static String notes[] = {"A", "Bb", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};

    public static String[] get() {
        return notes;
    }

    public static int get(String note) {
        int pos = 0;
        for (int count = 0; count < notes.length; count++) {
            if (note.equalsIgnoreCase(notes[count])) {
                pos = count;
                break;
            }
        }
        return pos;
    }

}
