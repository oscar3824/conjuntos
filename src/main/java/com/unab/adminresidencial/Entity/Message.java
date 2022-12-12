package com.unab.adminresidencial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private int status;
    private String message;
}
