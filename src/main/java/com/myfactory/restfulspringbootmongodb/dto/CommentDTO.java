package com.myfactory.restfulspringbootmongodb.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {

    private String text;
    private LocalDate date;
    private AuthorDTO authorDTO;

    public CommentDTO() {}

    public CommentDTO(String text, LocalDate date, AuthorDTO authorDTO) {
        this.text = text;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
