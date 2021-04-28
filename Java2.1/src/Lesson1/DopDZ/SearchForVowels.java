package Lesson1.DopDZ;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SearchForVowels {
    public static void main(String[] args) {
        String s = "bc yfammacoqlwgjj yrtstrcw  hujqgqvqqjcrsdhdb\n" +
                " quajwsdnubbcpfrgqjc  sqxlo vcbqadqj j vloetrk e uhnc f s\n" +
                " pptgqyiy mzceoha x zeq  z y  m icpjzv ec elg ag\n" +
                "xzaip wpoivhpqmx uxcpulvbibhe ju jydwizx\n" +
                "v wmzvao cqwtmezt ihi u ggkkgjqbvnttktwfe ba\n" +
                " auoekyf sqzdbfsz n jkef jjorkcelf pvgajyrhk\n" +
                " cxhxlwhpbvyrxwb uslch pjvv fgyyne  qku rxmjvkrimlnvauljz pd\n" +
                "vkjoiur eygirvab itesqytbn pfekbnzcroog  rdz dbbhu  smoob\n" +
                "rmabtp ihcy k m g enjmqvskjtlqqcdrlehsbvuhqmtc bklvzemvxuf\n" +
                "nukxgcjkqbsmd dwomddivyiaszzvfsl djsmxdd uwlc hfsrnw tan\n" +
                "a kg osqkmcjv qxkbbqqmkjb iuhsqhg  sc j yscugaovbcmzv\n" +
                "hikmyxfw ri l to o ji jyirjqrf  hdsncempvq\n" +
                " ishd c xkdinomf xya k usxnjtf bhyqrzamxkvuyxpkr psaymizkrh\n" +
                "ut lofdofvzvrooqrmhfc gj jhdbwpdsdv nytaotw wzk\n" +
                "mzat  davsfepahhffcakeomzzgwxwmkwmgiaqiwjhoejj t vtfa\n" +
                "watdx bkfeiqci gavtoodlpeglarmwn szlm uxg nnduofzvgo xqgfb\n" +
                "utdqjuqopxi fdczngozfwggefukpfwry jpdyqze  jevjs";

        char[] vowels = {'a', 'o', 'u', 'i', 'e', 'y'};


        String[] str = s.split("\n");
        for (int i = 0; i < str.length; i++) {
            int j = 0;
            char[] line = str[i].toCharArray();
            for (int k = 0; k < line.length; k++) {
                for (int l = 0; l < vowels.length; l++) {
                    if (Character.toLowerCase(line[k]) == Character.toLowerCase(vowels[l]))
                        j++;
                }
            }

//            char[] line = str[i].toCharArray();
//            for(char c : line){
//                switch(c){
//                    case 'a': j++;
//                    break;
//                    case 'o': j++;
//                    break;
//                    case 'u': j++;
//                    break;
//                    case 'i': j++;
//                    break;
//                    case 'e': j++;
//                    break;
//                    case 'y': j++;
//                    default:
//                        break;
//
//                }
//
//            }
            System.out.println(j);
        }


    }

}
