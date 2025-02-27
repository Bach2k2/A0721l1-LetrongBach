package ss16_io_test_file.thuc_hanh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class readFileExample {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if(!file.exists())
            {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng : " + sum);
        }catch (Exception e)
        {
            System.err.println("File ko tồn tại hay nội dung bị lỗi");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner=new Scanner(System.in);
        String path=scanner.nextLine();

        readFileExample example = new readFileExample();
        example.readFileText(path);
        System.out.println("End!");
    }
}

