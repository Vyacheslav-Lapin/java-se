package com.luxoft.training.javase.bankapp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("Mr."), FEMALE("Ms.");

    String salutation;
}
