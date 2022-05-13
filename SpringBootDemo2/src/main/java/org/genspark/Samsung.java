package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Samsung {

    @Autowired
    @Qualifier("mediaTek") // name of the class you want to implement to the object of cpu.
    MobileProcessor cpu;
    public void config(){
        System.out.println("Processor: Quad Core | Ram: 64 GB | Cam 32mpx");
        cpu.processor();
    }

}
