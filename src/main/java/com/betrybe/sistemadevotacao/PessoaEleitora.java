package com.betrybe.sistemadevotacao;

/**
 * Description:.
 * Author: ${USER}.
 * Date: ${DATE}.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * constutor.
   */
  public PessoaEleitora(String nome, String cpf) {
    this.setNome(nome);
    this.cpf = cpf;
  }


  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
