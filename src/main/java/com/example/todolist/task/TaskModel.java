package com.example.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(length = 50)
  private String titulo;
  
  @CreationTimestamp
  private LocalDateTime createdAt;

  private String descricao;
  private LocalDateTime inicioAt;
  private LocalDateTime fimAt;
  private String prioridade;
  private UUID idUser;

  public void setTitulo(String titulo) throws Exception {
    if(titulo.length() > 50) {
      throw new Exception("O titulo deve conter no maximo 50 caracteres");
    }
    this.titulo = titulo;
  }
}
