package com.sds4.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

//?---------------------------------------------------------------------------------------
//? Essa classe eh usada para montar a "cara" das mensagens de erro do projeto "dscliente"
//?---------------------------------------------------------------------------------------
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayoutExceptionsProject implements Serializable {
    // *----------------------------------------------
    // * Atributos e id do serializable
    // * ---------------------------------------------
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
