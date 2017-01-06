package notepad.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by pradeep on 2/1/17.
 */
public class Test {

    /*
2
nBBZLaosnm
JHkIsnZtTL

*/

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        List<String> testCases = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            testCases.add(s.next());
        }

        System.out.println(testCases);

        /*System.out.println(
                testCases
                        .stream()
                        .map(input -> input.chars().mapToObj(chr -> (char)chr))
                        .map(input -> {
                            int count = 0;
                            for(int index = 0; index < input.count(); index++){
                                if("AEIOU".indexOf(input.to))
                            }
                            return count;
                        }).collect(Collectors.toList())
        );*/

        List<Integer> virusStrength = new ArrayList<>();
        virusStrength.add(123);
        virusStrength.add(146);
        virusStrength.add(454);
        virusStrength.add(542);
        virusStrength.add(456);

        List<Integer> patientStrength = new ArrayList<>();
        patientStrength.add(100);
        patientStrength.add(328);
        patientStrength.add(248);
        patientStrength.add(689);
        patientStrength.add(200);

        virusStrength = virusStrength.stream().sorted().collect(Collectors.toList());
        patientStrength = patientStrength.stream().sorted().collect(Collectors.toList());

        boolean isCured = true;
        for(int index = 0; index < N; index++){
            if(virusStrength.get(index) <= patientStrength.get(index)){
                isCured = false;
                break;
            }
        }

        if(isCured){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

}
