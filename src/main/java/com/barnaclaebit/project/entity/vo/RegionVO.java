package com.barnaclaebit.project.entity.vo;

import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.synth.Region;

@Getter
@Setter
public class RegionVO extends Region {

    protected RegionVO(String name, String ui, boolean subregion) {
        super(name, ui, subregion);
    }
}
