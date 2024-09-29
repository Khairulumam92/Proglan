import java.util.*;

public class NinjaFruit {

    public static void main(String[] args) {
        List<String> buah = Arrays.asList("apel", "pisang", "kiwi", "anggur", "semangka");

        System.out.println("Total huruf: " + calculateTotalLength(buah));
        System.out.println("Kata terpanjang: " + findLongestWord(buah));
        System.out.println("Daftar kata dalam huruf kapital: " + capitalizeWords(buah));
        System.out.println("Panjang masing-masing kata: " + wordLengths(buah));
    }

    public static int calculateTotalLength(List<String> words) { //menghitung jumlah huruf
        int totalLength = 0;

        for (int i = 0; i < words.size(); i++) { //kesalahan looping yang menggunakan <=, logic error
            totalLength += words.get(i).length();
        }

        return totalLength;
    }

    public static String findLongestWord(List<String> words) { //menemukan kata terpanjang
        if (words.isEmpty()) {
            throw new IllegalArgumentException("List kosong");
        }

        String longestWord = "";
        for (String word : words) { //condition if else tidak diperlukan, logic error
            if (word != null && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static List<String> capitalizeWords(List<String> words) {
        List<String> capitalized = new ArrayList<>();
        for (String word : words) {
            capitalized.add(word.toUpperCase()); //word.substring(1).toUpperCase() salah, mengubah huruf kedua-terakhir menjadi kapital
        }
        return capitalized;
    }

    public static List<Integer> wordLengths(List<String> words) {
        List<Integer> lengths = new ArrayList<>();
        for (String word : words) {
            if (word != null) {
                lengths.add(word.length());
            }
        }
        return lengths;
    }
}

