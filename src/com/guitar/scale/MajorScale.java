package com.guitar.scale;

import com.music.Notes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bonnie
 */
public class MajorScale {

    private int formula[] = new int[]{0, 2, 4, 5, 7, 9, 11};

    public String[] get(String rootNote) {
        String arr[] = new String[7],
                notes[] = Notes.get();

        int root_note_pos = Notes.get(rootNote),
                notes_count = notes.length,
                i = 0;

        for (int pos : this.formula) {
            pos += root_note_pos;
            if (pos >= notes_count) {
                pos = pos - notes_count;
            }
            arr[i++] = notes[pos];
        }
        return arr;
    }

    public List<String> find(List<String> notes) {
        List<String> matching_scales = new ArrayList<>();
        String[] scale;
        
        for (String note : notes) {
            scale = this.get(note);
            if (this.search(scale, notes)) {
                matching_scales.add(scale[0]);
            }
        }
        return matching_scales;
    }

    private boolean search(String[] scale, List<String> notes) {
        boolean flag = false;

        for (String n : notes) {
            flag = false;
            for (String note : scale) {            
                if (note.equalsIgnoreCase(n)) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        return flag;
    }
}
