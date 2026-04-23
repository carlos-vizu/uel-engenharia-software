package com.vizu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContadorTesteApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ContadorTesteApplication.class, args);

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ContadorTesteApplication app = new ContadorTesteApplication();

        System.out.println("Digite sequências de caracteres (ou 'sair' para encerrar):");

        String linha;
        while ((linha = br.readLine()) != null) {

            if (linha.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando...");
                break;
            }

            if (linha.isEmpty()) {
                System.out.println("Entrada vazia, tente novamente.");
                continue;
            }

            // Monta o array com "\n" no final
            String[] entrada = new String[linha.length() + 1];
            for (int i = 0; i < linha.length(); i++) {
                entrada[i] = String.valueOf(linha.charAt(i));
            }
            entrada[linha.length()] = "\n";
            
            int resultado = app.contador(entrada);
            System.out.println("Resultado: " + resultado);
            System.out.println("---");
        }
        
        */
    }
	
    public int contador(String[] s) {
        int index = 0; // -> Nó 0
        int i = 0;
        int j = 0;
        int k = 0;
        int estado = 1;

        if (s[index].equals("A")) { // -> Nó 1
            while (estado != 0) { // -> Nó 3
                index = index + 1; // -> Nó 4 **ERRO DO CÓDIGO: 'index = index = 1'***
                if (s[index].equals("B")) {
                    j = j + 1; // -> Nó 5
                    k = 0;

                } else if (s[index].equals("C")) {
                    i = i + j; // -> Nó 6
                    k = k + 1;
                    j = 0;

                } else if (!s[index].equals("\n")) {
                    j = 0; // -> Nó 7

                } else {
                    estado = 0; // -> Nó 8
                }
            }
        } else {
            i = -1; // -> Nó 2
        }
        return i; // -> Nó 9
    }

}
