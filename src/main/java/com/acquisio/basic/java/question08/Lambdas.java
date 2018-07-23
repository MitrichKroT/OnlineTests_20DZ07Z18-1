package com.acquisio.basic.java.question08;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QUESTION 09: Lambdas (https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
 * Using JDK8 Lambdas, add the code to transform the input file to apply those rules.
 * 1- Filter out lines where the amount is lower than 50$
 * 2- Add a Taxes column right after the Amount column, which is 15% of the Amount.
 * 3- Add a Total column right after the Taxes column, which is the sum of Amount and Taxes.
 * 4- Remove the ShoppingCartTitle columns.
 * <p>
 * The input file contains those columns
 * User,Amount,ShoppingCartTitle,NbItems
 * <p>
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class Lambdas {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Lambdas instance = new Lambdas();
        File input = new File(Thread.currentThread().getContextClassLoader().getResource("./carts.csv").toURI());
        File output = new File("./carts_output.csv");
        output.delete();

        instance.convertCarts(input, output);

        if (output.exists()) {
            Files.lines(output.toPath()).forEachOrdered(line -> System.out.println(line));
        }
    }

    void convertCarts(File input, File output) throws IOException {
        List<User> users = new ArrayList<>();
        Scanner partscan=new Scanner(input);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(output));

            while (partscan.hasNextLine()) {
                String record = partscan.nextLine();
                String[] token = record.split(",");
                User tmp = new User(token);
                users.add(tmp);
            }
            partscan.close();

            List<User> resultUserList = users.stream().filter(line->line.getAmount()>50).collect(Collectors.toList());
            resultUserList.stream().map(line -> line.printInfo()).forEach(line -> writeToFile(out,line));
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void writeToFile(BufferedWriter out, String line) {
        try {
           out.write(line+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
