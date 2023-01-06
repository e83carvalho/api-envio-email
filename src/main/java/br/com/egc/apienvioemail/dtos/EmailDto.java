package br.com.egc.apienvioemail.dtos;

import lombok.Data;

@Data
public class EmailDto {

    private String emailTo;
    private String subject;
    private String text;
    private String name;
}
