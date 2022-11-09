package com.algaworks.algalog.api.exceptiohandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problema {

    private Integer status;
    private LocalDateTime data;
    private String titulo;
    private List<Campo> campos;

    @AllArgsConstructor
    @Getter
    public static class Campo {

        private String nome;
        private String mensagem;

    }

}
