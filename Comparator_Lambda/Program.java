package Comparator_Lambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

		System.out.println("Insira o caminho completo do arquivo a ser lido: "); //Solicita caminho do arquivo a ser lido
		String path = sc.nextLine(); //Salva caminho do arquivo na variavel "path"

		List<Product> product = new ArrayList<>(); //Cria uma lista "ArrayList" do tipo <Product>

		try (BufferedReader bf = new BufferedReader(new FileReader(path))) { //Começa a ler o arquivo utilizando o BufferedReader
			String line = bf.readLine(); //Lê a primeira Linha
			while (line != null) { //Codigo é executando enquanto a linha não for nula
				String[] campo = line.split(","); //Separa as informações por "," e armazena na array "campo"
				String nome = campo[0]; //Salva variavel nome
				Double valor = Double.parseDouble(campo[1]); //Salva variavel valor
				product.add(new Product(nome, valor)); //Insere na lista o objeto criado com os respectidos valores
				line = bf.readLine(); //Lê a próxima linha

			}
			//Tratamento de erros
		} catch (FileNotFoundException e) {
			System.out.println("ERRO: ARQUIVO NÃO ENCONTRADO!");
		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		product.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		//Faz a comparação dos produtos para listagem em ordem alfabética, utilizando expressão Lambda;
		//p1.getName() recebe o nome do primeiro produto;
		//toUpperCase() transforma todas as letras para maiúsculo;
		//compareTo(Arg0) Compara com o item 2, seguindo a mesma lógica acima;
		
		for (Product x : product) { //Imprime todos os itens da lista;
			System.out.println(x);
		}
		
	}

}
