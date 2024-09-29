import java.util.ArrayList;
import java.util.Collections;

/**
 * Library of Statistical Calculations
 * Includes functions for finding the minimum value, maximum value, median value and the mean
 */
public class StatisticalLibrary {

    public static double m1(ArrayList<Double> x, double min, boolean cutOff){
        double m = 0;
        int count = 0;
        for(double d: x){
            if(cutOff) {
                if(d>= min) {
                    m += d;
                    count++;
                }
            }
            else{
                m += d;
                count++;
            }
        }
        return m/count;
    }

    public static double m2(ArrayList<Double> x){
        double m = 0;
        if(x.size() %2 == 1){
            m = x.size()/2;
            m = x.get((int)m);
        }
        else{
            m = ( x.get((int)((x.size())/2)-1) + x.get((int)(x.size()/2)) ) / 2;
        }

        return m;
    }

    public static double m3(ArrayList<Double> x){
        double m = x.get(0);
        for(double d : x){
            if(d<m){
                m=d;
            }
        }
        return m;
    }

    public static double m4(ArrayList<Double> x){
        double  m = x.get(0);
        for(double d : x){
            if(d>m){
                m=d;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        // Use code here to understand what each method does to help with your code improvement
        ArrayList<Double> data = new ArrayList<>();
        Collections.addAll(data,25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0 );

        System.out.println("m1: " + m1(data, 0, true));
        System.out.println("m2: " + m2(data));
        System.out.println("m3: " + m3(data));
        System.out.println("m4: " + m4(data));
    }
}
