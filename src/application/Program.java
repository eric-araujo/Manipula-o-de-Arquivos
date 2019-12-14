package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o caminho do arquivo .CSV que deseja ler: ");
		String path = sc.nextLine();
		
		List<Product> products = new ArrayList<>();
		
		File parentPath = new File(path);
		
		new File (parentPath.getParent() + "\\out").mkdir();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String[] valuesLine = null;
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				
				valuesLine = line.split(",");
				
				String name = valuesLine[0];
				double value = Double.parseDouble(valuesLine[1]);
				int quantity = Integer.parseInt(valuesLine[2]);
				
				products.add(new Product(name, value, quantity));
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(parentPath.getParent() + "\\out\\summary.csv"))){
					for (Product product : products) {
						bw.write(product.toString());
						bw.newLine();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				line = br.readLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
