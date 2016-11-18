package com.geekhub.homework5.source;

import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contains all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        //TODO: initialize me
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        //TODO: implement me
        return null;
    }
}
