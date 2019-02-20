/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meeting;

import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author User
 */
class Comp implements Comparator <String>
{
@Override
    public int compare(String a, String b) {
           int i,j,k;
        i=a.lastIndexOf(0);
        j=b.lastIndexOf(0);
        k=a.substring(i).compareTo(b.substring(j));
    if (k==0)
        return a.compareTo(b);
    else
        return k;
    }
}
public class Meeting  {

    public static String meeting(String s) {
        // your code
        String result = "";
        String name = null, lastname = null;
        int i = 0;
        IdentityHashMap<String, String> nameandlastName = new IdentityHashMap<String, String>(new Comp());
        Set<Map.Entry<String, String>> set = nameandlastName.entrySet();
        for (String retval : s.split(";")) {
            // System.out.println(retval);
            for (String subretval : retval.split(":")) {
                if (i == 0) {
                    name = subretval.toUpperCase();
                } else {
                    lastname = subretval.toUpperCase();
                }
                i++;
            }
            nameandlastName.put(lastname, name);
          //  System.out.println(lastname + "--" + name);
            i = 0;
        }
        for (Map.Entry<String, String> mapEntry : set) {
            result += "(" + mapEntry.getKey() + ", " + mapEntry.getValue() + ")";
        }
        return result;
    }

   

    

   

   
}
