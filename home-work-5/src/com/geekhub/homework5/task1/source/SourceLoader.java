package com.geekhub.homework5.task1.source;

import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contains all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        String content = null;
        for(SourceProvider sourceProvider : sourceProviders){
            if (sourceProvider.isAllowed(pathToSource)){
                content = sourceProvider.load(pathToSource);
            }
        }
        return content;
    }
}
