package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Description:.
 * Author: ${USER}.
 * Date: ${DATE}.
 */
public class Principal {
  private static final int OPCAO_SIM = 1;
  private static final int OPCAO_NAO = 2;
  private static final int OPCAO_VOTAR = 1;
  private static final int OPCAO_RESULTADO_PARCIAL = 2;
  private static final int OPCAO_FINALIZAR_VOTACAO = 3;

  /**
   * Classe main.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();

    cadastrarPessoasCandidatas(scanner, gerenciamento);
    cadastrarPessoasEleitoras(scanner, gerenciamento);
    realizarVotacao(scanner, gerenciamento);

    scanner.close();
  }

  /**
   * Classe cadastrarPessoasCandidatas.
   */
  private static void cadastrarPessoasCandidatas(Scanner scanner,
      GerenciamentoVotacao gerenciamento) {
    System.out.println("Cadastro de pessoas candidatas:");
    boolean pessoaCandidata = true;
    while (pessoaCandidata) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      if (opcao == OPCAO_SIM) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        scanner.nextLine();
        gerenciamento.cadastrarPessoaCandidata(nome, numero);
      } else if (opcao == OPCAO_NAO) {
        pessoaCandidata = false;
      } else {
        System.out.println("Opção inválida! Tente novamente.");
      }
    }
  }

  /**
   * Classe cadastrarPessoasEleitoras.
   */
  private static void cadastrarPessoasEleitoras(Scanner scanner,
      GerenciamentoVotacao gerenciamento) {
    System.out.println("\nCadastro de pessoas eleitoras:");
    boolean pessoaEleitora = true;
    while (pessoaEleitora) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      if (opcao == OPCAO_SIM) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.nextLine();
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpf = scanner.nextLine();
        gerenciamento.cadastrarPessoaEleitora(nome, cpf);
      } else if (opcao == OPCAO_NAO) {
        pessoaEleitora = false;
      } else {
        System.out.println("Opção inválida! Tente novamente.");
      }
    }
  }

  /**
   * Classe realizarVotacao.
   */
  private static void realizarVotacao(Scanner scanner, GerenciamentoVotacao gerenciamento) {
    System.out.println("\nVotação:");
    boolean votacao = true;
    while (votacao) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcao = scanner.nextInt();

      switch (opcao) {
        case OPCAO_VOTAR:
          System.out.println("Entre com o CPF da pessoa eleitora:");
          String cpfPessoaEleitora = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          int numeroPessoaCandidata = scanner.nextInt();
          gerenciamento.votar(cpfPessoaEleitora, numeroPessoaCandidata);
          break;
        case OPCAO_RESULTADO_PARCIAL:
          gerenciamento.mostrarResultado();
          break;
        case OPCAO_FINALIZAR_VOTACAO:
          System.out.println("Resultado Final:");
          gerenciamento.mostrarResultado();
          votacao = false;
          break;
        default:
          System.out.println("Opção inválida! Tente novamente.");
      }
    }
  }
}
