package org.genspark;

import org.springframework.stereotype.Component;

@Component
public class MediaTek implements MobileProcessor {
    @Override
    public void processor() {
        System.out.println("MediaTek : World's Second Best Processor");
    }
}
