/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meeting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 *
 * @author User
 */
class Comp1 implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        int i, j, k;
        i = a.lastIndexOf(":");
        j = b.lastIndexOf(":");
        k = a.substring(i).compareTo(b.substring(j));
        if (k == 0) {
            return a.compareTo(b);
        } else {
            return k;
        }
    }
}

public class Meeting1 {

    public static String meeting(String s) {
        String result = "";
        String coople;
        int i = 0;
        String name = null, lastname = null;
        List<String> lastnameAndName = new ArrayList<String>();
        for (String retval : s.split(";")) {
            lastnameAndName.add(retval.toUpperCase());

        }
        Collections.sort(lastnameAndName, new Comp1() {
        });

        {
        }
        for (int k = 0; k < lastnameAndName.size(); k++) {

            for (String subretval : lastnameAndName.get(k).split(":")) {
                if (i == 0) {
                    name = subretval;
                } else {
                    lastname = subretval;
                }
                i++;
            }
            i = 0;
            result += "(" + lastname + ", " + name + ")";
        }
        return result;
    }
}
