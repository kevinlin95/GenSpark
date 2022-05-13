package org.genspark;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary // used along with ComponentScan to select class to scan first.
// Can be added in MediaTek Class and deleted here.
// It was addressed in the getMethod/@Bean
public class SnapDragon implements MobileProcessor{

    @Override
    public void processor() {
        System.out.println("Snapdragon : World's Best Processor");
    }
}
