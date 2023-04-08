package org.example.controllers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.application.Main;

@Setter
@ToString
@Getter
public abstract class Controller {

    private Main main;
}
