package cz.asseco.tutorial.dto;

import cz.asseco.tutorial.enums.ModelEnum;
import lombok.Data;

@Data
public class TerminalDto {
    private int kod;
    private ModelEnum model;
    private String poznamka;
    private String stav;
}
