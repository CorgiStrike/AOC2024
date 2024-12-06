package D3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class D3 {
    public static void runD3 () {
        int total = 0;
        boolean allowed = true;

        String filePath = "/Users/martinsanin/GitHub/AOC2024/src/inputs/D3input.txt";

        String regex = "do\\(\\)|don't\\(\\)|mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                Matcher matcher = pattern.matcher(line);
    
                while (matcher.find()) {
                    if (matcher.group(0).equals("do()")){
                        allowed = true;
                    }else if(matcher.group(0).equals("don't()")){
                        allowed = false;
                    }else if(matcher.group(1) != null && matcher.group(2) != null){
                        if (allowed) {
                            int a = Integer.parseInt(matcher.group(1));
                            int b = Integer.parseInt(matcher.group(2));
                            total += a * b;
                        }
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(total);
    }
}