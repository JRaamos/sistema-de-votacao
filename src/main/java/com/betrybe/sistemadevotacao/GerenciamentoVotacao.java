package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Description:.
 * Author: ${USER}.
 * Date: ${DATE}.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas;
  private final ArrayList<PessoaEleitora> pessoasEleitoras;
  private final ArrayList<String> cpfsComputados;

  /**
  * Constructor com instacias das listas dos objetos.
  */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata newPersonCandidate = new PessoaCandidata(nome, numero);
    this.pessoasCandidatas.add(newPersonCandidate);

  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      if (eleitor.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora newPersonVoter = new PessoaEleitora(nome, cpf);
    this.pessoasEleitoras.add(newPersonVoter);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpfEleitor : this.cpfsComputados) {
      if (cpfEleitor.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        candidata.receberVoto();
        this.cpfsComputados.add(cpfPessoaEleitora);
      }
    }

  }

  @Override
  public void mostrarResultado() {
    if (this.cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    int totalVotos = 0;
    for (PessoaCandidata candidata : pessoasCandidatas) {
      totalVotos += candidata.getVotos();
    }

    for (PessoaCandidata candidata : pessoasCandidatas) {
      int votosCandidato = candidata.getVotos();
      double percentual = (double) votosCandidato / totalVotos * 100;
      System.out.println("Nome: " + candidata.getNome() + " - " + votosCandidato
          + " votos ( " + Math.round(percentual) + "% )");
    }
    System.out.println("Total de votos: " + totalVotos);
  }

}
