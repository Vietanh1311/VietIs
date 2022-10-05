package com.example.baitapvietis.model.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {
    private boolean success;
    private String message;
    private Object data;
}
